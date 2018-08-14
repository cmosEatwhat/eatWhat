<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>OneManage后台管理模板 </title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${path}/res/layui/css/layui.css" media="all" >
	<link rel="stylesheet" href="${path}/res/css/public.css" media="all" />
</head>
<body class="childrenBody">
<fieldset class="layui-elem-field layui-field-title site-title">
   <legend><a name="methodRender">添加友情链接</a></legend>
 </fieldset>
<form class="layui-form linksAdd">
	<input type="hidden" name="id" value="${friendLink.id }">
	<!-- <div class="layui-form-item">
		<div class="layui-upload-list linkLogo">
			<img class="layui-upload-img linkLogoImg">
		</div>
	</div> -->
	<div class="layui-form-item">
		<label class="layui-form-label">网站名称</label>
		<div class="layui-input-block">
			<input type="text" name="webname" value="${friendLink.webname }" class="layui-input linkName" lay-verify="required" placeholder="请输入网站名称" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">网站地址</label>
		<div class="layui-input-block">
			<input type="text" name="alink" value="${friendLink.alink }" class="layui-input linkUrl" lay-verify="required|url" placeholder="请输入网站地址" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">站长邮箱</label>
		<div class="layui-input-block">
			<input type="text" name="email" value="${friendLink.email }" class="layui-input masterEmail" lay-verify="required|email" placeholder="请输入站长邮箱" />
		</div>
	</div>
	<!-- <div class="layui-form-item">
		<label class="layui-form-label">展示位置</label>
		<div class="layui-input-block">
			<input type="checkbox" class="layui-input showAddress" lay-text="首页|子页" lay-skin="switch" />
		</div>
	</div> -->
	<div class="layui-form-item">
			<label class="layui-form-label">站点描述</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入站点描述" name="content" class="layui-textarea">${friendLink.content }</textarea>
			</div>
		</div>
	<div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div>
</form>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/linkList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>