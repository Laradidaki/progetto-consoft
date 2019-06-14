<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Employee</title>

<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/add-employee-style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>ERM Employee Relationship Manager </h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Employee</h3>
		
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
		
		<!-- need to associate this data with employee id -->
		<form:hidden path="idEmployee"/>
		
		
		<table>
			<tbody>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td><label>Client:</label></td>
					<td><form:input path="client"/></td>
				</tr>
				<tr>
					<td><label>Work Hours:</label></td>
					<td><form:input path="workHours"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
		
			</tbody>
		
		</table>
		
		</form:form>
			
		<div style=""clear; both;"></div>
		
			<p>
				<a href="${pageContext.request.contextPath}/employee/list">Back to the employees list</a>
			</p>
	
	</div>

</body>
</html>