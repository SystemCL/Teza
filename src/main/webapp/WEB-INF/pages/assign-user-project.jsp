<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Assign user to project page</title>
<style>
     <%@ include file="MenuStyle.css"%>
     
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>

</head>
<body>
<h2>Assign user to project page</h2>
<jsp:include page="header.jsp" />

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Here you can assign user to project.</p>

<form:form method="POST" commandName="assignuserproject" action="${pageContext.request.contextPath}/assign-user-project.html">
<h2 align="center">Complete details</h2>
<table align="center">
<tbody>

 	<tr>
		  <td>
			<form:select style="color:dark; font-size:15px; height:36px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; font-weight:bolder; color:#686868;" path="project.id" enctype="multipart/form-data">
				<option value="Select" label=" - Project - " ></option>
			       <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
			</form:select>  
	      </td>
	</tr> 
	<tr>
		  <td>
			<form:select style="color:dark; font-size:15px; height:36px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; font-weight:bolder; color:#686868;" path="utilisateur.id" enctype="multipart/form-data">
				<option value="Select" label=" - User - " ></option>
			       <form:options items="${utilisateursList}" path="utilisateur_id" itemValue= "id" itemLabel= "fullName"></form:options>
			</form:select>  
	      </td>
	</tr>
	

	
	
	<tr>
	</br>
	<td><tr></tr></td>
	<td align="center"><input type="submit" value="Assign" class="button button1" /></td>
		<td></td>
		<td></td>
	</tr>
 <%-- 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  --%>
 
</tbody>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
  <h3>Only Admin can add assign users to projects!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For assign new projects please login as Admin!</h3>
</sec:authorize>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>