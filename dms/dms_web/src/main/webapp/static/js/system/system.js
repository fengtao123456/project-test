$(function () {
    //变量的抽取:
     var systemDatagrid=$('#systemDatagrid');
     var systemDlg=$('#systemDlg');
     var  systemForm=$('#systemForm');


    //datagrid
    systemDatagrid.datagrid({
        url: 'system/list',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
            /*使用遍历:遍历的是Velocity中上下文的对象:
            * fieldList
            *                  {field: 'id', title: 'id', width: '10%',align:  'center'},
            * */
           {field: 'id', title: '编号', width: '10%',align:  'center'},
           {field: 'name', title: '系统名称', width: '10%',align:  'center'},
           {field: 'compname', title: '公司名称', width: '15%',align:  'center'},
           {field: 'phone', title: '公司电话', width: '15%',align:  'center'},
           {field: 'fax', title: '公司传真', width: '10%',align:  'center'},
           {field: 'address', title: '公司地址', width: '20%',align:  'center'},
           {field: 'url', title: '公司网址', width: '20%',align:  'center'},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  systemDlg
            systemDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            systemForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = systemDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  systemDlg
                systemDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                systemForm.form('clear');
                //表单数据的回显:
                systemForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = systemDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('system/delete?id='+row.id,function (d) {
                            //d的处理
                          if(d.success){
                              //true:成功
                              $.messager.alert('操作提示',d.msg,'info');
                              //页面刷新
                              cmdObj.refresh();
                          }else{
                              //false:失败:提示
                              $.messager.alert('错误提示',d.msg,'error');
                          }

                        },'json')
                    }
                });
            }else{
                $.messager.alert('温馨提示','请选中需要删除的行!!','warning');
            }
        },
        'refresh':function () {
            //datagrid的重新加载: $("selector").datagrid('funName');
            systemDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            systemForm.form('submit', {
                    url:'system/saveOrUpdate',
                onSubmit: function(){
            },
            success:function(data){
             // {"success":true,"msg":"操作成功"}==>json字符串
                var $data = $.parseJSON(data);
                //弹框提示和刷新
                if($data.success){
                    $.messager.alert('操作提示',$data.msg,'info');
                }else{
                    $.messager.alert('错误提示',$data.msg,'error');

                }

                systemDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            systemDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})