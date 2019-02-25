<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%--引入公共依赖--%>
   <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script src="static/js/findLost/findLost.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="findLostDatagrid"></table>
<%--toolbar--%>
<div id="toolbar">
    <div style="padding-bottom: 10px">
        <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
        <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true" >编辑</a>
        <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true" >删除</a>
        <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
    </div>
    <!-- 这部门是查询的功能 -->
    <div>
        <form id="searchForm" action="/employee/download" method="post">
            档案：<input name="archive" class="easyui-textbox" style="width:80px;height:32px">
            日期: <input name="beginTime" class="easyui-DateTimeBox" style="width:120px;height:32px">
            到：<input name="endTime" class="easyui-DateTimeBox" style="width:120px;height:32px">

            <a href="javaScript:void(0);" data-cmd="search"  class="easyui-linkbutton" iconCls="icon-search">查找</a>

            <a href="#" data-cmd="export"  class="easyui-linkbutton" iconCls="icon-redo">导出</a>
        </form>
    </div>
</div>
<%--添加或者编辑的dialog--%>
<div id="findLostDlg" class="easyui-dialog" style="width: 400px"
     closed="true" buttons="#dlg-buttons">
    <form id="findLostForm" method="post" novalidate style="margin:0;padding:20px 50px">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>
            <tr>
                <td>
                    档案:<input class="easyui-combobox" name="archive.id"
                              data-options="valueField:'id',textField:'title',panelHeight:'auto',url:'/archive/all'">
                </td>
            </tr>
            <tr>
                <td>
                    用户:<input class="easyui-combobox" name="employee.id"
                              data-options="valueField:'id',textField:'username',panelHeight:'auto',url:'/employee/all'">
                </td>
            </tr>
            <tr>
                <td>
                    找回日期:<input class="easyui-DateTimeBox" name="finddate">
                </td>
            </tr>
            <tr>
                <td>
                    备注:<input type="text" name="descs">
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
