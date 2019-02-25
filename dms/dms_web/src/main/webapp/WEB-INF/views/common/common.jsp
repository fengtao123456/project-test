<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<base href="<%=basePath%>">
<%--引入easyui的依赖--%>
<%--主题样式--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/default/easyui.css">
<%--图标样式--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/icon.css">
<%--颜色--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/color.css">
<%--jquery依赖--%>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<%--easyui的插件--%>
<script type="text/javascript" src="static/js/easyui/jquery.easyui.min.js"></script>
<%--国际化--%>
<script type="text/javascript" src="static/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<%--引入jquery.serializejson.js文件，此插件的作用是直接拿到一个表单中的所有值，并且封装成一个json数据.--%>
<script type="text/javascript" src="static/js/jquery/plugin/jquery.serializeJSON/jquery.serializejson.js"></script>
<%--验证的支持--%>
<link href="static/js/easyui/plugin/validatebox/jeasyui.extensions.validatebox.css" rel="stylesheet"/>
<script type="text/javascript" src="static/js/easyui/plugin/validatebox/jeasyui.extensions.validatebox.rules.js"></script>