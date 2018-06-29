<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglib.jsp"%>
<html>
<head>
    <title>管理页面</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/icon.css">
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>

    <script>
        function openTab(text,url,icon){
            if($("#tabs").tabs("exists",text)){
                $("#tabs").tabs("select",text);
            }else{
                var content="<iframe scrolling='auto' frameborder='0' style='width:100%;height:100%' src='"+url+"'></iframe>";
                $("#tabs").tabs("add",{
                    title:text,
                    iconCls:icon,
                    closable:true,
                    content:content
                });
            }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:100px;"></div>
<div data-options="region:'south',split:true" style="height:50px;"></div>
<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
<div data-options="region:'west',title:'West',split:true" style="width:200px;">
    <div id="aa" class="easyui-accordion" fit="true">
        <div title="流程管理" data-options="iconCls:'icon-home',selected:true" style="overflow:auto;padding:10px;">
            <a href="javascript:openTab('新建流程1','1.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">新建流程1</a>
            <a href="javascript:openTab('新建流程2','2.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">新建流程2</a>
        </div>
        <div title="用户管理" data-options="iconCls:'icon-home'" style="padding:10px;">
            <a href="javascript:openTab('用户列表','1.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">用户列表</a>
            <a href="javascript:openTab('添加用户','1.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">添加用户</a>
            <a href="javascript:openTab('删除用户','1.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">删除用户</a>
        </div>
        <div title="文章管理" data-options="iconCls:'icon-home'" style="padding:10px;">

        </div>
        <div title="权限管理" data-options="iconCls:'icon-home'" style="padding:10px;"></div>
        <div title="系统管理" data-options="iconCls:'icon-cut'" style="padding:10px;"></div>
    </div>
</div>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">

    </div>
</div>
</body>
</html>
