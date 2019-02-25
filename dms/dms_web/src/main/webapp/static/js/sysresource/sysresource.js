//对象转换（Status）--注意负数需要使用引号修饰，因为不能识别【<s>标签就是在字体上加一条下划线】
function formatStatus(action){
    var data={
        0:"<div style='color:green;'>正在使用</div>",
        '-1':"<div style='color:red;'>禁用</div>"
    };
    return data[action];
}
//验证扩展:两次数据是否一致
$.extend($.fn.validatebox.defaults.rules, {
    equals: {
        //value是在确认密码文本框输入的值，而param是获取的密码的值
        validator: function(value,param){
            return value == $(param[0]).val();
        },
        message: '两次密码不匹配.'
    }
});
//验证扩展：用户名是否可以重复使用
$.extend($.fn.validatebox.defaults.rules, {
    checkUsername: {
        validator: function(value,param){
            var employeeId = $("#employeeId").val();
            //发送ajax查询数据库判断用户名是否重复
            var result = $.ajax({
                type: "GET",
                url: "/employee/checkUsername",
                data:{username:value,id:employeeId},
                async: false//修改异步为同步，解决当还未发送就已经打印出'用户名重复.'
            }).responseText;
            return result=="true";
        },
        message: '用户名重复.'
    }
});
$(function () {
    //变量的抽取:
     var sysresourceDatagrid=$('#sysresourceDatagrid');
     var sysresourceDlg=$('#sysresourceDlg');
     var  sysresourceForm=$('#sysresourceForm');
    var searchForm = $("#searchForm");

    //datagrid
    sysresourceDatagrid.datagrid({
        url: 'sysResource/likeQuery',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        toolbar:"#toolbar",
        columns: [[
           {field: 'name', title: '资源名称', width: '30%',align:  'center'},
           {field: 'url', title: '资源路径', width: '30%',align:  'center'},
           {field: 'descs', title: '描述', width: '30%',align:  'center'},
           {field: 'status', title: '资源使用状态', width: '10%',align:  'center',formatter:formatStatus},
        ]]
    });

    //按钮的事件
    var cmdObj={
        'search':function () {
            //准备 高级查询表单里面 searchForm 组件 一次性获取添加参数
            //获取表单里面输入的值 url(需要先引入 jquery.serializejson.js 才可以使用这个方法)
            var params =  searchForm.serializeJSON();
            // console.debug(params)
            //表示使用一些参数查询数据。/employee/page
            sysresourceDatagrid.datagrid('load',params)
        },
        'add':function () {
            //弹出一个dialog,里面装form表单  sysresourceDlg
            sysresourceDlg.dialog('open').dialog('center').dialog('setTitle','部门添加');
            //清空表单
            sysresourceForm.form('clear');
        },
        'edit':function () {
            //先获取编辑的数据
            var row = sysresourceDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                //弹出dialog,进行数据的回显
                //弹出一个dialog,里面装form表单  sysresourceDlg
                sysresourceDlg.dialog('open').dialog('center').dialog('setTitle','部门修改');
                //清空表单
                sysresourceForm.form('clear');
                //表单数据的回显:
                sysresourceForm.form('load',row);
            }else{
                $.messager.alert('温馨提示','请选中需要编辑的行!!','warning');
            }
        },
        'delete':function () {
            //先获取删除的数据
            var row = sysresourceDatagrid.datagrid('getSelected');
            //做一个判断:是否选中
            if (row){
                $.messager.confirm('温馨提示','你确定删除:[<font color="pink">'+row.name+"</font>]吗?",function(r){
                    // 选中:确认的操作:调用后台的删除方法:发送ajax调用
                    if (r){
                        // 发送ajax调用 $.get(url,params,function(d){},type)
                        $.get('sysResource/delete?id='+row.id,function (d) {
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
            sysresourceDatagrid.datagrid('reload');
        },
        'submit':function(){
            //提交:表单的提交:
            sysresourceForm.form('submit', {
                    url:'sysResource/saveOrUpdate',
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

                sysresourceDlg.dialog('close');
                //页面刷新
                cmdObj.refresh();
            }
        });
        },
        'cancel':function(){
            //关闭dialog,不清空form,在打开dialog的时候清空
            sysresourceDlg.dialog('close');
        }

    };

    //toolbar绑定事件:如果按钮禁用了怎么办?下午具体实现
    $("a[data-cmd]").on('click',function () {
        //data-cmd="add"
        var dataCmd=$(this).data('cmd');
        cmdObj[dataCmd]();
    });
})