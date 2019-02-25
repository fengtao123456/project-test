<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入shiro的文件--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript">
        //入口函数
        $(function () {
            var $mainUI = $("#mainUI");
            //JS方式去创建树形结构
            $("#menuTree").tree({
                //当有权限模块的时候需要通过用户的id来查询菜单再返回json格式的数据
                url: "util/loginUserMenus",
                onClick: function (node) {
                    //执行tabs中的中getTab方法
                    //第一次点击为Null
                    //根据url来判断
                    if (node.url) {
                        var tab = $mainUI.tabs("getTab", node.text);
                        if (tab) {
                            //执行选中已经打开的选项卡的
                            $mainUI.tabs("select", node.text);
                        } else {
                            //点击菜单,创建选项卡
                            //1.给菜单绑定点击事件
                            //2.点击的时候执行添加操作
                            $mainUI.tabs("add", {
                                title: node.text,
                                iconCls: node.iconCls,
                                closable: true,
                                content: '<iframe frameborder="0" style="width: 100%;height: 100%" src="' + node.url + '"></iframe>'
                            });
                        }
                    }
                }
            });
        })
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height: 50px;">
    <%--<audio autoplay="autoplay"><source src="/mp3/onj001.mp3" type="audio/mpeg"></audio>--%>
    <%--<embed src="/mp3/BRYNHILDR IN THE DARKNESS -EJECTRO Extended-.mp3" hidden="true" autostart="true" loop="false" >--%>
    <%-- <audio controls="controls" autoplay="autoplay">
         <source src="/mp3/onj001.mp3" type="audio/mpeg"/>
     </audio>--%>
    <h3>档案管理系统</h3>
        <%--获取用户名--%>
        <div style="float:right" >
            欢迎
            <span style="color:#ff3126">
                <shiro:user>
                    <%--<shiro:principal/>未修改主体之前能直接获取用户名Object principal = employee.getUsername()--%>
                    <%--当把主体修改成了Employee对象用户的时候就要在此处添加用户名的参数才能获取用户名，
                            否则显示整个对象的详细信息在页面上--%>
                    <shiro:principal property="username"/>
                </shiro:user>
            </span>
            登录,<a href="/logout">退出</a>
        </div>
</div>
<div data-options="region:'south',split:true" style="height: 5%;">
    ©版权所有.违法必究
</div>
<div data-options="region:'west',split:true" title="导航菜单"
     style="width: 15%;">
    <ul id="menuTree"></ul>
</div>
<div id="mainUI" class="easyui-tabs" data-options="region:'center'">
    <div title="主页" style="padding: 10px">
        <%--<h1>欢迎来到智障销售系统</h1>--%>
        <%--<img alt="" src="images/1.jpg" height="100%">--%>
        <%--<iframe frameborder="0" style="width: 100%;height: 100%" src="http://www.baidu.com"></iframe>--%>
        <%--<iframe frameborder="0" style="width: 100%;height: 100%" src="http://www.baidu.com"></iframe>--%>

    </div>
</div>
</body>
</html>
