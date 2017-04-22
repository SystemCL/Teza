<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<title>Edit project page</title>
<style>
     <%@ include file="MenuStyle.css"%>
</style>
</head>
<body>
	<h1>Edit project page</h1>
	<jsp:include page="header.jsp" />
	<h2 align="center">Edit project details</h2>
	<p>${message}</p>
	<form:form method="POST" commandName="project"
		action="${pageContext.request.contextPath}/project/edit/${project.id}.html">
		<table align="center">
			<tbody>
				<tr>
					<td>Nom project:</td>
					<td><form:input class="info" path="nomProject" required="required"/></td>
				</tr>
				
				<tr>
					<td>Domain:</td>
					<td><form:input class="info" path="domain" required="required"/></td>
				</tr>
				
				<tr>
					<td>Date creation:</td>
					<fmt:formatDate value="${cForm.dateCreationP}" pattern="yyyy-MM-dd" var="formattedDate"/> 
					<td><form:input type="date" style="color:dark; font-size:15px; height:35px; width:169px; 
							box-sizing: border-box;border: 2px solid #ccc; border-radius: 9px;" 
                            path="dateCreationP" name = "dateCreationP" value = "${formattedDate}" />
                    </td>
				</tr>

				<tr>
					</br>
					<td><tr></tr></td>
					<td></td>
					<td><input type="submit" value="Edit" class="button button1" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/index.html">Home page</a>
	</p>
</body>
</html>