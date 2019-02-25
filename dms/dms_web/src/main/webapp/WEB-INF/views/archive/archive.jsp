<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2019/1/16
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%--引入公共依赖--%>
   <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script src="static/js/archive/archive.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="archiveDatagrid"></table>
<%--toolbar--%>
<div id="toolbar">
    <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
    <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true" >编辑</a>
    <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true" >删除</a>
    <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
</div>
<%--添加或者编辑的dialog--%>
<div id="archiveDlg" class="easyui-dialog" style="width: 400px"
     closed="true" buttons="#dlg-buttons">
    <form id="archiveForm" method="post" novalidate style="margin:0;padding:20px 50px">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>

            <tr>
                <td>
                    档案编号:<input type="text" name="sn">
                </td>
            </tr>
            <tr>
                <td>
                    档案类型:<input type="text" name="doctypemanageId">
                </td>
            </tr>
            <tr>
                <td>
                    档案存档点:<input type="text" name="docpositionsId">
                </td>
            </tr>
            <tr>
                <td>
                    档案标题:<input type="text" name="title">
                </td>
            </tr>
            <tr>
                <td>
                    建档用户:<input type="text" name="employeeId">
                </td>
            </tr>
            <tr>
                <td>
                    建档日期:<input type="text" name="inputtime">
                </td>
            </tr>
            <tr>
                <td>
                    修改用户:<input type="text" name="updateuser">
                </td>
            </tr>
            <tr>
                <td>
                    修改日期:<input type="text" name="updatedate">
                </td>
            </tr>
            <tr>
                <td>
                    借阅状态:<input type="text" name="statusId">
                </td>
            </tr>
            <tr>
                <td>
                    过期时间:<input type="text" name="expirationdate">
                </td>
            </tr>
            <tr>
                <td>
                    过期是否提前通知:<input type="text" name="expirationnotice">
                </td>
            </tr>
            <tr>
                <td>
                    提前通知的天数:<input type="text" name="noticedays">
                </td>
            </tr>
            <tr>
                <td>
                    档案内容:<input type="text" name="content">
                </td>
            </tr>
            <tr>
                <td>
                    内容简介:<input type="text" name="intro">
                </td>
            </tr>
            <tr>
                <td>
                    是否常用:<input type="text" name="manyuser">
                </td>
            </tr>
            <tr>
                <td>
                    文件编号:<input type="text" name="documentsn">
                </td>
            </tr>
            <tr>
                <td>
                    发文部门:<input type="text" name="comefromdepartmentId">
                </td>
            </tr>
            <tr>
                <td>
                    发文单位:<input type="text" name="comefromunitId">
                </td>
            </tr>
            <tr>
                <td>
                    发文人:<input type="text" name="postman">
                </td>
            </tr>
            <tr>
                <td>
                    批准时间:<input type="text" name="approvaltime">
                </td>
            </tr>
            <tr>
                <td>
                    鉴定时间:<input type="text" name="identificationtime">
                </td>
            </tr>
            <tr>
                <td>
                    产品批号:<input type="text" name="productid">
                </td>
            </tr>
            <tr>
                <td>
                    原料批号:<input type="text" name="materialid">
                </td>
            </tr>
            <tr>
                <td>
                    数量:<input type="text" name="number">
                </td>
            </tr>
            <tr>
                <td>
                    页数:<input type="text" name="page">
                </td>
            </tr>
            <tr>
                <td>
                    专利号:<input type="text" name="patentnumber">
                </td>
            </tr>
            <tr>
                <td>
                    年检负责人:<input type="text" name="inspector">
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
