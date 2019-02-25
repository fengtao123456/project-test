function headFormat(data) {
    if (data) {
        return '<img src=' + data + ' alt="头像消失了..." style="height: 50px"/>';
    }
}
function statusFormat(data) {
    if (data) {
        return '禁用';
    } else {
        return "启用";
    }
}
function departmentFormat(data) {
    if (data) {
        return data.name;
    } else {
        return "顶级";
    }
}
$(function () {
    //变量的抽取:
     var employeeDatagrid=$('#employeeDatagrid');
     var employeeDlg=$('#employeeDlg');
     var  employeeForm=$('#employeeForm');

    //datagrid
    employeeDatagrid.datagrid({
        url: 'employee/list',
        fit:true,
        title:'员工管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'username', title: '用户名', width: '10%',align:  'center'},
           {field: 'password', title: '密码', width: '10%',align:  'center'},
           {field: 'realname', title: '真实姓名', width: '10%',align:  'center'},
           {field: 'identcard', title: '身份证', width: '10%',align:  'center'},
           {field: 'inputdate', title: '录入日期', width: '10%',align:  'center'},
           {field: 'phone', title: '电话', width: '10%',align:  'center'},
           {field: 'educdetailId', title: '学历', width: '10%',align:  'center'},
           {field: 'address', title: '密码', width: '10%',align:  'center'},
           {field: 'sexdetailId', title: '性别', width: '10%',align:  'center'},
           {field: 'birthday', title: '生日', width: '10%',align:  'center'},
           {field: 'descs', title: '密码', width: '10%',align:  'center'},
           {field: 'status', title: '状态', width: '10%',align:  'center',formatter:statusFormat},
           {field: 'department', title: '部门', width: '10%',align:  'center',formatter:departmentFormat},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'add':function () {
            //弹出一个dialog,里面装form表单  employeeDlg
            employeeDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            employeeForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = employeeDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  employeeDlg
                employeeDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                employeeForm.form('clear');
                //表单数据的回显:
                employeeForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = employeeDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('employee/delete?id='+row.id,function (d) {
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
            employeeDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            employeeForm.form('submit', {
                    url:'employee/saveOrUpdate',
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

                employeeDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            employeeDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})