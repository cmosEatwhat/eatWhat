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
<body class="">
<div class="layui-fluid">
<fieldset class="layui-elem-field layui-field-title site-title">
   <legend><a name="methodRender">编辑定时任务</a></legend>
 </fieldset>
 
<form class="layui-form">
	<input type="hidden" name="id" value="${quarz.id }">
		<%-- <div class="layui-form-item">
			<label class="layui-form-label"></label>
			<div class="layui-input-block">
				<input type="text" name="id" value="${quarz.id }" class="layui-input" lay-verify="required" placeholder="请输入" />
			</div>
		</div> --%>
		<div class="layui-form-item">
			<label class="layui-form-label">定时器名称</label>
			<div class="layui-input-block">
				<input type="text" name="jobName" value="${quarz.jobName }" class="layui-input" lay-verify="required" placeholder="请输入定时器名称" style="width:40%"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">所属组</label>
			<div class="layui-input-block">
				<input type="text" name="jobGroup" value="${quarz.jobGroup }" class="layui-input" lay-verify="required" placeholder="请输入所属组" style="width:40%"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">类路径</label>
			<div class="layui-input-block">
				<input type="text" name="classPath" value="${quarz.classPath }" class="layui-input" lay-verify="required" placeholder="请输入类路径" style="width:40%"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">cron表达式</label>
			<div class="layui-input-block">
				<input type="text" name="cronStr" value="${quarz.cronStr }" class="layui-input" lay-verify="required" placeholder="请输入cron表达式" style="width:40%"/>
				表达式编写可使用cron生成器
			</div>
		</div>
		<%-- <div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<input type="text" name="state" value="${quarz.state }" class="layui-input" lay-verify="required" placeholder="请输入状态" />
			</div>
		</div> --%>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" name="mark" value="${quarz.mark }" class="layui-input" lay-verify="required" placeholder="请输入备注" style="width:40%"/>
			</div>
		</div>
	
	<!-- 按钮 -->
	<!-- <div class="layui-form-item">
		<button class="layui-btn layui-block" lay-filter="addLink" lay-submit>提交</button>
	</div> -->
	<div class="layui-form-item" style="padding-left:230px;">
			<button class="layui-btn one-tj" lay-submit lay-filter="addLink">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
</form>
</div>
<script type="text/javascript" src="${path}/res/layui/layui.js"></script>
<script type="text/javascript" src="${path}/res/js/one-js/quarzList.js"></script>
<script type="text/javascript">
	var path = "${path}";
</script>
</body>
</html>