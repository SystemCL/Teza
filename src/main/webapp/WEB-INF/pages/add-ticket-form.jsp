<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add ticket page</title>
</head>
<body>
<h1>Add ticket page</h1>
<jsp:include page="header.jsp" />

<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Here you can add a new ticket.</p>

<form:form method="POST" commandName="ticket" action="${pageContext.request.contextPath}/ticket/add.html">
<h2 align="center">Fill ticket details</h2>
<table align="center" border="0px">
  <tr>
    <th> </th>
    <th> </th>
    <th> </th>
  </tr>
  
  <tr>
  	<td>
  		<form:input class="info" placeholder="Ticket name" path="nomTicket" required="required"/> 
  	</td>
  	<td>
 	    <form:select style="color:dark; font-size:15px; height:33px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; height:41px;"  class="info" path="utilisateur.id" enctype="multipart/form-data">
	      <option value="Select" label=" - User - " ></option>
               <form:options items="${utilisateursList}" path="utilisateur_id" itemValue= "id" itemLabel= "fullName"></form:options>
          </form:select>   
    </td>
  	
  </tr>
  
  <tr>
  		<fmt:formatDate value="${cForm.dateCreationT}" pattern="yyyy-MM-dd" var="formattedDate"/>
	<td>
		<form:input style="color:dark; font-size:15px; height:33px; width:170px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; height:41px;" type="date" placeholder="Creation date" path="dateCreationT" name = "dateCreationT" value = "${formattedDate}" />
	</td>
  	<td>
  		<form:select style="color:dark; font-size:15px; height:33px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; height:41px;" path="project.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Project - " ></option>
                 <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
            </form:select>  
  	</td>
  </tr>
  		
  <tr>
  	<td>
  		<form:input placeholder="Subject" class="info" path="sujetTicket" required="required"/>
  	</td>
  	<td>
  		<form:select style="color:dark; font-size:15px; height:33px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; height:41px;" path="permission.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Permission - " ></option>
                 <form:options items="${permissionsList}" path="permission_id" itemValue= "id" itemLabel= "nomPermission"></form:options>
            </form:select>
  	</td>
  	
  </tr>
   
  <tr>
  	<td>
  	</td>
  	<td>
  		<form:select style="color:dark; font-size:15px; height:33px; width:169px; border-radius:7px; border:2px solid #ccc; box-sizing: border-box; height:41px;" path="priority.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Priority - " ></option>
                 <form:options items="${prioritiesList}" path="priority_id" itemValue= "id" itemLabel= "nomPriority"></form:options>
            </form:select>
  	</td>
  </tr>
  
  <tr>
  	<th colspan="2">
  		<!-- <input style="font-size:20px;" type="submit" value="Add" onclick="return confirm('Add ticket with current values?')" /> -->
  		
<!-- <button type="submit" value="Add" onclick="return confirm('Add ticket with current values?')">Submit</button> -->

		<input type="submit" value="Add" class="button button1" />
  	 </th>

  </tr>



<%-- <tbody>
	<tr>
		<td><form:input class="info" placeholder="Ticket name" path="nomTicket" required="required"/></td>
	</tr>
	
	<tr>
	    <fmt:formatDate value="${cForm.dateCreationT}" pattern="yyyy-MM-dd" var="formattedDate"/>
		<td><input style="color:dark; font-size:15px; height:33px; width:165px;" type="date" placeholder="Creation date" path="dateCreationT" name = "dateCreationT" value = "${formattedDate}" /></td>
	
	 <fmt:formatDate value="${cForm.dateCreationP}" pattern="yyyy-MM-dd" var="formattedDate"/> 
	   <td><form:input style="color:dark; font-size:15px; height:33px; width:165px;" type="date" path="dateCreationP"  name="dateCreationP" value = "${formattedDate}" /></td> 
	
	</tr>
	
	<tr>
		<td align="center"><form:input placeholder="Subject" class="info" path="sujetTicket" required="required"/></td>
	</tr>

	<tr>
		<td>Etat ticket:</td>
		<td><form:input path="etatTicket" required="required"/></td>
	</tr>
	
	<tr>
	     <td>
 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;"  class="info" path="utilisateur.id" enctype="multipart/form-data">
	        <option value="Select" label=" - User - " ></option>
                 <form:options items="${utilisateursList}" path="utilisateur_id" itemValue= "id" itemLabel= "fullName"></form:options>
            </form:select>   
         </td>
	</tr>
	
	<tr>
	     <td>
 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="project.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Project - " ></option>
                 <form:options items="${projectsList}" path="project_id" itemValue= "id" itemLabel= "nomProject"></form:options>
            </form:select>  
         </td>
    </tr> 
    
    <tr>
	     <td>
 	        <form:select style="color:dark; font-size:15px; height:33px; width:169px;" path="permission.id" enctype="multipart/form-data">
	        <option value="Select" label=" - Permission - " ></option>
                 <form:options items="${permissionsList}" path="permission_id" itemValue= "id" itemLabel= "nomPermission"></form:options>
            </form:select>  
         </td>
    </tr> 
	
	
	<tr>
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
		<td align="right"><input type="submit" value="Add" onclick="return confirm('Add ticket with current values?')" /></td>
		<td></td>
	</tr>
 
</tbody> --%>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
  <h3>Only Admin can add new tickets!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For add new tickets, please login first</h3>
</sec:authorize>


<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>