<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<title>Edit user page</title>
<style>
     <%@ include file="MenuStyle.css"%>
     
</style>
</head>
<body>
<h2>Edit user page</h2>
<jsp:include page="header.jsp" />
<h2 align="center">Edit user details</h2>
<p>${message}</p>
<form:form method="POST" commandName="utilisateur" action="${pageContext.request.contextPath}/utilisateur/edit/${utilisateur.id}.html">
<table align="center" border="0px">
<tbody>

	<tr>
		<td>First name:</td>
		<td><form:input class="info" path="firstName" required="required"/></td>
	</tr>
	
	<tr>
		<td>Last name:</td>
		<td><form:input class="info" path="lastName" required="required"/></td>
	</tr>
	
	<tr>
		<td>Age:</td>
		<td><form:input class="info" path="age" required="required" /></td>
	</tr>
	
<%-- 	<tr>
		<td>Enrolment date:</td>
		<td><form:input path="enrolment_date" /></td>
	</tr> --%>
	<%-- <tr>
	    <td>Project:</td>
	     <td>
	        <form:select path="project.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Select - " ></option>
                 <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
            </form:select>  
         </td>
	</tr> --%>

	<tr>
	<td></td>
	</br>
	<td><input type="submit" value="Edit" class="button button1" /></td>
	<td></td>
	</tr>
</tbody>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>