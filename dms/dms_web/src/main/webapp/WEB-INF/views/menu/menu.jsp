    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <html>
        <head>

        <title>Title</title>
        <%--引入公共依赖--%>
        <%@include file="/WEB-INF/views/common/common.jsp" %>
        <script src="static/js/menu/menu.js"></script>
        </head>
        <body>

        <%--toolbar--%>
        <div id="toolbar">
        <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
        <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true"
        >编辑</a>
        <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true"
        >删除</a>
        <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true"
        >刷新</a>
        <%--高级查询功能 菜单名称，父菜单--%>
        <div>
            <form id="searchForm" action="" method="post">

            菜单名称:<input name="name" class="easyui-textbox" style="width:80px;height:32px">
            父菜单:<input class="easyui-textbox" name="parent.id"  style="width:80px;height:32px">
            <a href="javascript:;" data-cmd="search" class="easyui-linkbutton" iconCls="icon-search">查找</a>
            </form>
        </div>
        </div>
        <%--datagrid--%>
        <table id="menuDatagrid"></table>

        <%--添加或者编辑的dialog--%>
        <div id="menuDlg" class="easyui-dialog" style="width: 400px"
        closed="true" buttons="#dlg-buttons">
        <form id="menuForm" method="post" style="width:400px;padding:10px">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>
        <tr>
        <td>
            菜单名
            </td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
        <td>
        父菜单
        </td>
            <td>
            <input class="easyui-combobox" name="parent.id"
            data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'menu/Parent'">
            </td>
        </tr>
        <tr>
        <td>
        资源路径:
        </td>
            <td>
            <input class="easyui-combobox" name="sysresource.id"
            data-options="valueField:'id',textField:'url',panelHeight:'auto',url:'sysResource/list'">
            </td>
        </tr>
        <tr>
        <td>
        图片路径
        </td>
            <td><input type="text" name="iconUrl"></td>
        </tr>
        <tr>
        <td>
        描述
        </td>
            <td><input type="text" name="descs"></td>
        </tr>
        <tr>
        <td>
        状态</td>
        <td>
        <select name="status" class="easyui-combobox" data-options="panelHeight:'auto'">
        <%--<option value="">--请选择--</option>--%>
        <option value="0">启用</option>
        <option value="1">不启用</option>
        </select>
        </td>

        </tr>
        </table>
        </form>
        </div>
        <%--dialog的button--%>
        <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" data-cmd="submit"
        style="width:90px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton c8" iconCls="icon-cancel" data-cmd="cancel"
        style="width:90px">取消</a>
        </div>
        </body>
        </html>
