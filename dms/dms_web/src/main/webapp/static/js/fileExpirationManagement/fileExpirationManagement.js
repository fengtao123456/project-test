$(function () {
    //变量的抽取:
     var fileExpirationManagementDatagrid=$('#fileExpirationManagementDatagrid');
     var fileExpirationManagementDlg=$('#fileExpirationManagementDlg');
     var  fileExpirationManagementForm=$('#fileExpirationManagementForm');


    //datagrid
    fileExpirationManagementDatagrid.datagrid({
        url: 'fileExpirationManagement/list',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'id', title: '编号', width: '10%',align:  'center'},
           {field: 'archive', title: '档案', width: '10%',align:  'center',formatter:function (data) {
                   return data.title;
               }},
           {field: 'employee', title: '用户', width: '10%',align:  'center',formatter:function (data) {
                   return data.username;
               }},
           {field: 'destorydate', title: '销毁日期', width: '10%',align:  'center'},
           {field: 'destory', title: '销毁原因', width: '10%',align:  'center',formatter:function (data) {
                   return data.name;
               }},
           {field: 'descs', title: '备注', width: '10%',align:  'center'},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  fileExpirationManagementDlg
            fileExpirationManagementDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            fileExpirationManagementForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = fileExpirationManagementDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //清空表单
                fileExpirationManagementForm.form('clear');
                //表单数据的回显:
                if(row.archive){
                    row["archive.id"] = row.archive.id;
                }
                if(row.employee){
                    row["employee.id"] = row.employee.id;
                }
                if(row.destory){
                    row["destory.id"] = row.destory.id;
                }
                fileExpirationManagementForm.form('load',row);
                //弹出一个dialog,里面装form表单  fileExpirationManagementDlg
                fileExpirationManagementDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = fileExpirationManagementDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.archive.title+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('fileExpirationManagement/delete?id='+row.id,function (d) {
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
            fileExpirationManagementDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            fileExpirationManagementForm.form('submit', {
                    url:'fileExpirationManagement/saveOrUpdate',
                onSubmit: function(){
            },
            success:function(data){
             // {"success":true,"msg":"操作成功"}==>json字符串
                var $data = JSON.parse(data);
                //弹框提示和刷新
                if($data.success){
                    $.messager.alert('操作提示',$data.msg,'info');
                }else{
                    $.messager.alert('错误提示',$data.msg,'error');

                }

                fileExpirationManagementDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            fileExpirationManagementDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})