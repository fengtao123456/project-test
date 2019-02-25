$(function () {
    //变量的抽取:
     var uploadDatagrid=$('#uploadDatagrid');
     var uploadDlg=$('#uploadDlg');
     var  uploadForm=$('#uploadForm');


    //datagrid
    uploadDatagrid.datagrid({
        url: 'upload/list',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'attachment', title: '附件编号', width: '10%',align:  'center'},
           {field: 'attachmenttypesId', title: '附件类型', width: '10%',align:  'center'},
           {field: 'attachmenturl', title: '附件文件保存路径', width: '10%',align:  'center'},
           {field: 'sn', title: '备注信息', width: '10%',align:  'center'},
           {field: 'archivesId', title: '所属档案编号', width: '10%',align:  'center'},
           {field: 'uploadtime', title: '上传时间', width: '10%',align:  'center'},
           {field: 'filesize', title: '文件大小', width: '10%',align:  'center'},
           {field: 'uploademployeeId', title: '上传用户', width: '10%',align:  'center'},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  uploadDlg
            uploadDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            uploadForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = uploadDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  uploadDlg
                uploadDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                uploadForm.form('clear');
                //表单数据的回显:
                uploadForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = uploadDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('upload/delete?id='+row.id,function (d) {
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
            uploadDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            uploadForm.form('submit', {
                    url:'upload/saveOrUpdate',
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

                uploadDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            uploadDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})