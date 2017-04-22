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

<title>Edit ticket page</title>
<style>
     <%@ include file="MenuStyle.css"%>
     
</style>
</head>
<body>
	<h1>Edit ticket page</h1>
	<jsp:include page="header.jsp" />
	<h2 align="center">Edit ticket details</h2>
	<p>${message}</p>
	<form:form method="POST" commandName="ticket"
		action="${pageContext.request.contextPath}/ticket/edit/${ticket.id}.html">
		<table align="center">
			<tbody>
				<tr>
					<td>Nom ticket:</td>
					<td><form:input class="info" path="nomTicket" required="required"/></td>
				</tr>
				
				<tr>
				<fmt:formatDate value="${cForm.dateCreationT}" pattern="yyyy-MM-dd" var="formattedDate"/>
					<td>Date creation:</td>
					<td><form:input type="date" style="color:dark; font-size:15px; height:33px; width:165px;" path="dateCreationT" name = "dateCreationT" value = "${formattedDate}" /></td>
				</tr>
				
				<tr>
					<td>Sujet ticket:</td>
					<td><form:input class="info" path="sujetTicket" required="required"/></td>
				</tr>
			
				<%-- <tr>
					<td>Etat ticket:</td>
					<td><form:input path="etatTicket" required="required"/></td>
				</tr> --%>
				
				<tr>
				    <td>Utilisateur:</td>
				     <td>
				        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="utilisateur.id" enctype="multipart/form-data">
				        <option value="Select" label=" - User - " ></option>
			                 <form:options items="${utilisateursList}" path="utilisateur_id" itemValue= "id" itemLabel= "firstName"></form:options>
			            </form:select>  
			         </td>
				</tr>
				<tr>
			    <td>Project:</td>
			     <td>
		 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="project.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Project - " ></option>
		                 <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
		            </form:select>  
		         </td>
		        </tr> 
		        
		        <tr>
			    <td>Permission:</td>
			     <td>
		 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="permission.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Permission - " ></option>
		                 <form:options items="${permissionsList}" path="permission_id" itemValue= "id" itemLabel= "nomPermission"></form:options>
		            </form:select>  
		         </td>
		        </tr> 
	
				<tr>
			    <td>Priority:</td>
			     <td>
		 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="priority.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Priority - " ></option>
		                 <form:options items="${prioritiesList}" path="priority_id" itemValue= "id" itemLabel= "nomPriority"></form:options>
		            </form:select>  
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