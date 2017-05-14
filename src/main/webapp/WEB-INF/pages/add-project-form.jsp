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
<title>Add project page</title>
<style>
     <%@ include file="MenuStyle.css"%>
     
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>

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
		<td><form:input class="info" placeholder="Project name" path="nomProject" required="required"/></td>
	</tr>
	
	<tr>
		  <td>
			<form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="domainProject.id" enctype="multipart/form-data">
				<option value="Select" label=" - Domain - " ></option>
			       <form:options items="${domainsList}" path="domain_id" itemValue= "id" itemLabel= "nameDomain"></form:options>
			</form:select>  
	      </td>
	</tr>
	
	<%-- <tr>
	  <fmt:formatDate value="${cForm.dateCreationP}" pattern="yyyy-MM-dd" var="formattedDate"/> 
	   <td><form:input style="color:dark; font-size:15px; height:33px; width:165px;" type="date" path="dateCreationP"  name="dateCreationP" value = "${formattedDate}" /></td> 
	    
	</tr> --%>
	
	<tr>
	</br>
	<td><tr></tr></td>
	<td align="center"><input type="submit" value="Add" class="button button1" /></td>
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
  <h3>Only Admin can add new projects!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For add new projects, please login first</h3>
</sec:authorize>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>