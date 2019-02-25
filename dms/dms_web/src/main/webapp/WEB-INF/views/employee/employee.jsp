<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%--引入公共依赖--%>
   <%@include file="/WEB-INF/views/common/common.jsp"%>
    <%--引入shiro的文件--%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    <script src="static/js/employee/employee.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="employeeDatagrid"></table>
<%--toolbar--%>
<div id="toolbar">
<shiro:hasPermission name="employee:save">
    <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
</shiro:hasPermission>
    <shiro:hasPermission name="employee:update">
    <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true" >编辑</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="employee:delete">
    <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true" >删除</a>
<<<<<<< .mine
</shiro:hasPermission>
<a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>

||||||| .r6
    <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
    <a data-cmd="offline" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-offline" plain="true" >离职</a>
    <%--高级查询功能--%>
    <%--用户名、姓名、电话、学历、入职日期、所在部门--%>
    <div>
        <form id="searchForm" action="" method="post">
            用户名:<input name="username" class="easyui-textbox" style="width:80px;height:32px">
            姓名:<input name="realname" class="easyui-textbox" style="width:80px;height:32px">
            电话:<input name="phone" class="easyui-textbox" style="width:80px;height:32px">
            学历:<input class="easyui-combobox" name="educdetailID"
                      data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'systemDictionaryDetail/education'">
            入职日期：<input  name="inputdate"  type="text" class="easyui-datebox" >
            所在部门: <input class="easyui-combobox" name="departmentID"
                         data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'department/all'">
            <a href="javascript:;" data-cmd="search" class="easyui-linkbutton" iconCls="icon-search">查找</a>
        </form>
    </div>
=======
    <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
    <a data-cmd="offline" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-offline" plain="true" >离职</a>
    <%--高级查询功能  我是测试--%>

    <%--用户名、姓名、电话、学历、入职日期、所在部门--%>
    <div>
        <form id="searchForm" action="" method="post">
            用户名:<input name="username" class="easyui-textbox" style="width:80px;height:32px">
            姓名:<input name="realname" class="easyui-textbox" style="width:80px;height:32px">
            电话:<input name="phone" class="easyui-textbox" style="width:80px;height:32px">
            学历:<input class="easyui-combobox" name="educdetailID"
                      data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'systemDictionaryDetail/education'">
            入职日期：<input  name="inputdate"  type="text" class="easyui-datebox" >
            所在部门: <input class="easyui-combobox" name="departmentID"
                         data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'department/all'">
            <a href="javascript:;" data-cmd="search" class="easyui-linkbutton" iconCls="icon-search">查找</a>
        </form>
    </div>
>>>>>>> .r7
</div>
<%--添加或者编辑的dialog--%>
<div id="employeeDlg" class="easyui-dialog" style="width: 400px"
     closed="true" buttons="#dlg-buttons">
    <form id="employeeForm" method="post" novalidate style="margin:0;padding:20px 50px">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>

            <tr>
                <td>
                    用户名:<input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>
                    密码:<input type="text" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    真实姓名:<input type="text" name="realname">
                </td>
            </tr>
            <tr>
                <td>
                    身份证:<input type="text" name="identcard">
                </td>
            </tr>
            <tr>
                <td>
                    录入日期:<input type="text" name="inputdate">
                </td>
            </tr>
            <tr>
                <td>
                    电话:<input type="text" name="phone">
                </td>
            </tr>
            <tr>
                <td>
                    学历:<input type="text" name="educdetailId">
                </td>
            </tr>
            <tr>
                <td>
                    密码:<input type="text" name="address">
                </td>
            </tr>
            <tr>
                <td>
                    性别:<input type="text" name="sexdetailId">
                </td>
            </tr>
            <tr>
                <td>
                    生日:<input type="text" name="birthday">
                </td>
            </tr>
            <tr>
                <td>
                    密码:<input type="text" name="descs">
                </td>
            </tr>
            <tr>
                <td>
                    状态:<input type="text" name="status">
                </td>
            </tr>
            <tr>
                <td>
                    部门:<input type="text" name="department">
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
