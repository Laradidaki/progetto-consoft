<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Employees</title>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>ERM - Employee Relationship Manager</h2>
	
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		            <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
		
		<input type="button" value="Add Employee"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
		/>
		
		<table>
		<tr>
		<th>Last name</th>
		<th>First name</th>
		<th>Client</th>
		<th>Work hours</th>
		<th>Action</th>
		</tr>
		
		<c:forEach var="tempEmployee" items="${employees}">
		
		<!-- construct an "update" link with employee id -->
		<c:url var="updateLink" value="/employee/showFormForUpdate">
		<c:param name="employeeId" value="${tempEmployee.idEmployee}"/>
		</c:url>
		
		<!-- construct an "delete" link with employee id -->
		<c:url var="deleteLink" value="/employee/delete">
		<c:param name="employeeId" value="${tempEmployee.idEmployee}"/>
		</c:url>
		
		<tr>
		<td> ${tempEmployee.lastName} </td>
		<td> ${tempEmployee.firstName} </td>
		<td> ${tempEmployee.client} </td>
		<td> ${tempEmployee.workHours} </td>
		
		<td>
			<!-- display the update link -->
			<a href="${updateLink}">Update</a>
			|
			<!-- display the delete link -->
			<a href="${deleteLink}" 
			 onclick="if(!(confirm('Are you sure you want to delete this employee?')))return false">Delete</a>
		</td>
		</tr>
		
		</c:forEach>
		</table>
	
		</div>
	
	</div>
</body>
</html>