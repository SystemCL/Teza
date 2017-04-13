<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add project page</title>
</head>
<body>
<h1>Add project page</h1>
<jsp:include page="header.jsp" />

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Here you can add a new project.</p>

<form:form method="POST" commandName="project" action="${pageContext.request.contextPath}/project/add.html">
<h2 align="center">Fill project details</h2>
<table align="center">
<tbody>

	<tr>
		<td>Nom project:</td>
		<td><form:input path="nomProject" required="required"/></td>
	</tr>
	
	<tr>
		<td>Domain:</td>
		<td><form:input path="domain" required="required"/></td>
	</tr>
	
	<tr>
		<td>Date creation:</td>
		<%-- <td><form:input path="enrolment_date" required="required" /></td> --%>
		<td><input type="date" path="dateCreationP" class= "date" name = "dateCreationP" value = "<fmt:formatDate value="${cForm.dateCreationP}" pattern="yyyy-MM-dd"" /></td>
	</tr>
	
	<tr>
	</br>
	<td><tr></tr></td>
	<td></td>
		<td align="right"><input type="submit" value="Add" onclick="return confirm('Add project with current values?')" /></td>
		<td></td>
	</tr>
 <%-- 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  --%>
 
</tbody>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
  <h3>Only Admin can add new projects!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For add new projects, please login first</h3>
</sec:authorize>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>