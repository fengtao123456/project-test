<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%--引入公共依赖--%>
   <%@include file="/WEB-INF/views/common/common.jsp"%>
    <script type="text/javascript"
     src="static/js/easyui/plugin/dataview/datagrid-groupview.js"></script>
    <script src="static/js/systemDictionaryDetail/systemDictionaryDetail.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="systemDictionaryDetailDatagrid"></table>
<%--toolbar--%>
<div id="toolbar">
    <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
    <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true" >编辑</a>
    <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove" plain="true" >删除</a>
    <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload" plain="true" >刷新</a>
    <%--高级查询功能  --%>


    <%--字典标识和字典类型模糊查询--%>

        <form id="searchForm" action="" method="post">
            字典标识:<input name="sn" class="easyui-textbox" style="width:80px;height:32px">
            字典类型:<input class="easyui-combobox" name="types.id"
             data-options="valueField:'id',textField:'name',
             panelHeight:'auto',url:'systemDictionaryType/all'">

            <a href="javascript:;" data-cmd="search" class="easyui-linkbutton" iconCls="icon-search">查找</a>
        </form>
    </div>
</div>
<%--添加或者编辑的dialog--%>
<div id="systemDictionaryDetailDlg" class="easyui-dialog" style="width:400px;padding:10px"
     closed="true" buttons="#dlg-buttons">
    <form id="systemDictionaryDetailForm" method="post">
        <%--编辑隐藏域的处理--%>
        <input type="hidden" name="id" >
        <table>

            <tr>
                <td>名称:</td>
                <td><input class="easyui-validatebox" type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>序号:</td>
                <td><input class="easyui-validatebox"  name="serial">
                </td>
            </tr>

            <tr>
                <td>类别:</td>
                <td>
                    <input class="easyui-combobox" name="types.id"
                           data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'systemDictionaryType/all'">
                </td>
            </tr>

            <tr>
                <td>是否启用:</td>
                <td>
                    <select name="status"  class="easyui-combobox" data-options="panelHeight:'auto'">
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
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" data-cmd="submit" style="width:90px">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c8" iconCls="icon-cancel" data-cmd="cancel" style="width:90px">取消</a>
</div>
</body>
</html>
