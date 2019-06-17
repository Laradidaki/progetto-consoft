<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
           <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Consoft Company Home Page</title>
</head>
<body>
	<h2>Consoft Company Home Page</h2>
	<hr>
	<p>
	Welcome to the Consoft Company home page!
	</p>
	
	<hr>
	
	<!-- display employee name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link to point to /leaders -- this is for the managers -->
	<p>
	<a href="${pageContext.request.contextPath}/leaders">Manager</a>
	Only for managers
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- add a link to point to /systems -- this is for admins -->
	<p>
	<a href="${pageContext.request.contextPath}/systems">Admin</a>
	Only for admins
	</p>
	</security:authorize>
	<hr>
	
	<!-- add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout"/>
	</form:form>
	
	
</body>
</html>