$(function () {
    //变量的抽取:
     var systemDictionaryTypeDatagrid=$('#systemDictionaryTypeDatagrid');
     var systemDictionaryTypeDlg=$('#systemDictionaryTypeDlg');
     var  systemDictionaryTypeForm=$('#systemDictionaryTypeForm');


    //datagrid
    systemDictionaryTypeDatagrid.datagrid({
        url: 'systemDictionaryType/list',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'sn', title: '字典标识', width: '10%',align:  'center'},
           {field: 'name', title: '类型名称', width: '10%',align:  'center'},
           {field: 'status', title: '是否启用', width: '10%',align:  'center'},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  systemDictionaryTypeDlg
            systemDictionaryTypeDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            systemDictionaryTypeForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = systemDictionaryTypeDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  systemDictionaryTypeDlg
                systemDictionaryTypeDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                systemDictionaryTypeForm.form('clear');
                //表单数据的回显:
                systemDictionaryTypeForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = systemDictionaryTypeDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('systemDictionaryType/delete?id='+row.id,function (d) {
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
            systemDictionaryTypeDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            systemDictionaryTypeForm.form('submit', {
                    url:'systemDictionaryType/saveOrUpdate',
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

                systemDictionaryTypeDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            systemDictionaryTypeDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})