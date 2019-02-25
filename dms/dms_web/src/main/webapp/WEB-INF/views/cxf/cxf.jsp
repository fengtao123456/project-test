<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--引入公共依赖--%>
    <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script src="/static/js/cxf/cxf.js"></script>
</head>
<body>
<div>
    号码归属地查询：<input type="text"  id="phoneNumber" />
    <input type="button" value="查询" id="submitPhone" placeholder="请输入你的电话号码">
</div>
</body>
</html>
