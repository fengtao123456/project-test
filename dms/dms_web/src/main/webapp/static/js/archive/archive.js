$(function () {
    //变量的抽取:
     var archiveDatagrid=$('#archiveDatagrid');
     var archiveDlg=$('#archiveDlg');
     var  archiveForm=$('#archiveForm');


    //datagrid
    archiveDatagrid.datagrid({
        url: 'archive/list',
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
           {field: 'sn', title: '档案编号', width: '10%',align:  'center'},
           {field: 'doctypemanageId', title: '档案类型', width: '10%',align:  'center'},
           {field: 'docpositionsId', title: '档案存档点', width: '10%',align:  'center'},
           {field: 'title', title: '档案标题', width: '10%',align:  'center'},
           {field: 'employeeId', title: '建档用户', width: '10%',align:  'center'},
           {field: 'inputtime', title: '建档日期', width: '10%',align:  'center'},
           {field: 'updateuser', title: '修改用户', width: '10%',align:  'center'},
           {field: 'updatedate', title: '修改日期', width: '10%',align:  'center'},
           {field: 'statusId', title: '借阅状态', width: '10%',align:  'center'},
           {field: 'expirationdate', title: '过期时间', width: '10%',align:  'center'},
           {field: 'expirationnotice', title: '过期是否提前通知', width: '10%',align:  'center'},
           {field: 'noticedays', title: '提前通知的天数', width: '10%',align:  'center'},
           {field: 'content', title: '档案内容', width: '10%',align:  'center'},
           {field: 'intro', title: '内容简介', width: '10%',align:  'center'},
           {field: 'manyuser', title: '是否常用', width: '10%',align:  'center'},
           {field: 'documentsn', title: '文件编号', width: '10%',align:  'center'},
           {field: 'comefromdepartmentId', title: '发文部门', width: '10%',align:  'center'},
           {field: 'comefromunitId', title: '发文单位', width: '10%',align:  'center'},
           {field: 'postman', title: '发文人', width: '10%',align:  'center'},
           {field: 'approvaltime', title: '批准时间', width: '10%',align:  'center'},
           {field: 'identificationtime', title: '鉴定时间', width: '10%',align:  'center'},
           {field: 'productid', title: '产品批号', width: '10%',align:  'center'},
           {field: 'materialid', title: '原料批号', width: '10%',align:  'center'},
           {field: 'number', title: '数量', width: '10%',align:  'center'},
           {field: 'page', title: '页数', width: '10%',align:  'center'},
           {field: 'patentnumber', title: '专利号', width: '10%',align:  'center'},
           {field: 'inspector', title: '年检负责人', width: '10%',align:  'center'},
           {field: 'status', title: '状态', width: '10%',align:  'center'},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  archiveDlg
            archiveDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            archiveForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = archiveDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  archiveDlg
                archiveDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                archiveForm.form('clear');
                //表单数据的回显:
                archiveForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = archiveDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('archive/delete?id='+row.id,function (d) {
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
            archiveDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            archiveForm.form('submit', {
                    url:'archive/saveOrUpdate',
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

                archiveDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            archiveDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})