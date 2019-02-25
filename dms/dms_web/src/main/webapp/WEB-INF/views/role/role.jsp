<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%--引入公共依赖--%>
   <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script src="static/js/role/role.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="roleDatagrid"></table>
<%--toolbar--%>
<div id="toolbar" style="padding:5px;height:auto">
    <div>
        <div style="margin-bottom:5px">
            <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
            <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true" >编辑</a>
            <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true" >删除</a>
            <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
        </div>
        <%--高级查询--%>
        <form id="searchForm" action="/employee/download" method="post">
            <%--textbox：文本框--%>
            角色名称: <input name="name" class="easyui-textbox" style="width:80px;height:32px">
            <a href="javaScript:;" data-cmd="search"  class="easyui-linkbutton" iconCls="icon-search">查找</a>
        </form>
    </div>
</div>
<%--添加或者编辑的dialog--%>
<div id="roleDlg" class="easyui-dialog" style="width: 400px"
     closed="true" buttons="#dlg-buttons">
    <form id="roleForm" method="post" novalidate style="margin:0;padding:20px 50px">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>

            <tr>
                <td>
                    标识:<input type="text" name="sn">
                </td>
            </tr>
            <tr>
                <td>
                    名称:<input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    描述:<input type="text" name="descs">
                </td>
            </tr>
            <tr>
                <td>
                    状态:<input type="text" name="status">
                </td>
            </tr>
        </table>
    </form>
</div>
<%--dialog的button--%>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" data-cmd="submit" style="width:90px">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c8" iconCls="icon-cancel" data-cmd="cancel" style="width:90px">取消</a>
</div>
</body>
</html>
