<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>档案管理系统</title>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript">
        //登录页面处理过期问题
        if(top != window){//如果不是顶级页面
            //把子页面的地址，赋值给顶级页面显示
            top.location.href = "/login";
        }
        function submitForm() {
            //提交表单
            $("#loginForm").form('submit',{
                url:"/login",
                success:function (data) {
                    var result = $.parseJSON(data);
                    if(result.success){
                        //跳转到成功页面 js跳转页面
                        location.href = '/util/main';
                    }else{
                        //打印错误信息 提示给用户看
                        $.messager.show({
                            title:'温馨提示',
                            msg:'登录问题:'+result.msg,
                            timeout:5000,
                            showType:'slide'
                        });
                    }
                }
            })
        }
        //回车登录功能
        $(function(){
            //绑定事件
            $(document.documentElement).on("keyup",function(event){
                //event对象
                var keyCode = event.keyCode;
                if(keyCode === 13){
                    submitForm();
                }
            });
        });
    </script>
</head>
<body>
<div align="center" style="margin-top: 100px;">
    <div class="easyui-panel" title="智销系统用户登陆" style="width: 350px; height: 240px;">
        <form id="loginForm" class="easyui-form" method="post">
            <table align="center" style="margin-top: 15px;">
                <tr height="20">
                    <td>用户名:</td>
                </tr>
                <tr height="10">
                    <td><input name="username" class="easyui-validatebox" required="true" value="admin" /></td>
                </tr>
                <tr height="20">
                    <td>密&emsp;码:</td>
                </tr>
                <tr height="10">
                    <td><input name="password" type="password" class="easyui-validatebox" required="true" value="0" /></td>
                </tr>
                <tr height="40">
                    <td align="center"><a href="javascript:;" class="easyui-linkbutton" onclick="submitForm();">登陆</a> <a
                            href="javascript:;" class="easyui-linkbutton" onclick="resetForm();">重置</a></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

