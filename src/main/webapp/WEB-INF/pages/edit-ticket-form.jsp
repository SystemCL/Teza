<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
					<td><form:input path="nomTicket" required="required"/></td>
				</tr>
				
				<tr>
					<td>Date creation:</td>
					<%-- <td><form:input path="enrolment_date" required="required" /></td> --%>
					<td><input type="date" path="dateCreationT" class= "date" name = "dateCreationT" value = "<fmt:formatDate value="${cForm.dateCreationT}" pattern="yyyy-MM-dd"" /></td>
				</tr>
				
				<tr>
					<td>Sujet ticket:</td>
					<td><form:input path="sujetTicket" required="required"/></td>
				</tr>
			
				<%-- <tr>
					<td>Etat ticket:</td>
					<td><form:input path="etatTicket" required="required"/></td>
				</tr> --%>
				
				<tr>
				    <td>Utilisateur:</td>
				     <td>
				        <form:select path="utilisateur.id" enctype="multipart/form-data">
				        <option value="Select" label=" - Select - " ></option>
			                 <form:options items="${utilisateursList}" path="utilisateur_id" itemValue= "id" itemLabel= "firstName"></form:options>
			            </form:select>  
			         </td>
				</tr>
				<tr>
			    <td>Project:</td>
			     <td>
		 	        <form:select path="project.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Select - " ></option>
		                 <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
		            </form:select>  
		         </td>
		        </tr> 
		        
		        <tr>
			    <td>Permission:</td>
			     <td>
		 	        <form:select path="permission.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Select - " ></option>
		                 <form:options items="${permissionsList}" path="permission_id" itemValue= "id" itemLabel= "nomPermission"></form:options>
		            </form:select>  
		         </td>
		        </tr> 
	
				<tr>
			    <td>Priority:</td>
			     <td>
		 	        <form:select path="priority.id" enctype="multipart/form-data">
			        <option value="Select" label=" - Select - " ></option>
		                 <form:options items="${prioritiesList}" path="priority_id" itemValue= "id" itemLabel= "nomPriority"></form:options>
		            </form:select>  
		         </td>
		        </tr> 
				<tr>
					</br>
					<td><tr></tr></td>
					<td></td>
					<td align="right"><input type="submit" value="Edit"
						onclick="return confirm('Are you sure you want to continue?')" /></td>
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