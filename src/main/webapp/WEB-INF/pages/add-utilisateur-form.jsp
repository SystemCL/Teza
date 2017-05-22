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
<title>Add user page</title>
<style>
     <%@ include file="MenuStyle.css"%>
     
</style>
</head>
<body>
<h2>Add user page</h2>
<jsp:include page="header.jsp" />

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Here you can add a new user.</p>

<form:form method="POST" commandName="utilisateur" action="${pageContext.request.contextPath}/utilisateur/add.html">
<h2 align="center">Fill utilisateur details</h2>
<table align="center" border="0px">
<tbody>

	<tr>
		<td><form:input class="info" placeholder="First name" path="firstName" required="required"/></td>
	</tr>
	
	<tr>
		<td><form:input class="info" placeholder="Last name" path="lastName" required="required"/></td>
	</tr>
	
	<tr>
		<td><form:input class="info" placeholder="Age" path="age" /></td>
	</tr>
	
	<tr>
	<td><tr></tr></td>
	<td align="center"><input type="submit" value="Add" class="button button1" /></td>
		
		<td></td>
	</tr>
 <%-- 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  --%>
 
</tbody>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
  <h3>Only Admin can add new users!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For add new users, please login first</h3>
</sec:authorize>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>