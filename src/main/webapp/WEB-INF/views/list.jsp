<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<script src="${APP_PATH}/static/js/jquery-1.7.2.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
		  <div class="col-xs-12">
		 	 <h1>SSM-CRUD</h1>
		 	 <table class="table table-hover">
		 	 	<tr>
		 	 		<td>#</td>
		 	 		<td>员工名称</td>
		 	 		<td>性别</td>
		 	 		<td>邮件</td>
		 	 		<td>部门</td>
		 	 	</tr>
		 	 	<c:forEach items="${pageInfo.list}" var="emp">
		 	 		<tr>
		 	 			<td>${emp.empId}</td>
		 	 			<td>${emp.empName}</td>
		 	 			<td>${emp.garder}</td>
		 	 			<td>${emp.email}</td>
		 	 		</tr>
		 	 	</c:forEach>
			</table>
		  </div>
		</div>
	</div>
</body>
</html>