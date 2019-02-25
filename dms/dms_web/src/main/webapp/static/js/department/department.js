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

function employeeFormat(data) {
    if (data) {
        return data.username;
    } else {
        return "无";
    }
}

$(function () {
    //变量的抽取:
     var departmentDatagrid=$('#departmentDatagrid');
     var departmentDlg=$('#departmentDlg');
     var  departmentForm=$('#departmentForm');
    // 高级搜索的表单
    var searchForm = $("#searchForm");

    departmentDatagrid.treegrid({
        url: 'department/allParent',
        title:'部门管理',
        idField:'id',
        treeField:'name',
        rownumbers:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'sn', title: '部门标识', width: '10%',align:  'center'},
           {field: 'name', title: '部门名称', width: '10%',align:  'center'},
           {field: 'phone', title: '联系电话', width: '10%',align:  'center'},
           {field: 'fax', title: '传真', width: '10%',align:  'center'},
           {field: 'url', title: '部门路径', width: '10%',align:  'center'},
           {field: 'employee', title: '部门主管', width: '10%',align:  'center',formatter:employeeFormat},
           {field: 'descs', title: '备注', width: '10%',align:  'center'},
           {field: 'status', title: '状态', width: '10%',align:  'center',formatter:statusFormat},
        ]]
    });

    //按钮的事件
    var cmdObj={
        search:function () {
            //需要先引入 jquery.jdirk.js 才可以使用这个方法
            var params =  $("#searchForm").serializeJSON();
            //重新请求路径
            console.debug(params);
            departmentDatagrid.treegrid('load',params);
        },
        'add':function () {
            //弹出一个dialog,里面装form表单  departmentDlg
            departmentDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            departmentForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = departmentDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  departmentDlg
                departmentDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                departmentForm.form('clear');
                //表单数据的回显:
                // console.debug(row)
                if(row.employee){
                    row["employee.id"]=row.employee.id;
                }
                if(row._parentId){
                    row["parent.id"]=row._parentId;
                }

                departmentForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = departmentDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('department/delete?id='+row.id,function (d) {
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
            // console.debug("zz")
            departmentDatagrid.treegrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            departmentForm.form('submit', {
                    url:'department/saveOrUpdate',
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

                departmentDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            departmentDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {

        var dataCmd=$(this).data('cmd');
        // console.debug(dataCmd);
        cmdObj[dataCmd]();
    });
})