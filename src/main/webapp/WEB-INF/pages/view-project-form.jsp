<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View selected project</title>
<style>
    <%@ include file="rectangle.css"%>
</style>
</head>
<body>
<h2>View selected project</h2>
<jsp:include page="header.jsp" />
<p>Here you can see the selected project from table.</p>     

<div id="rectangle">
<table border=1px align="center">
    <tr>
    	<th>Name:</th>
    	<td>${project.nomProject}</td>
    </tr>
    <tr>	
    	<th>Domain:</th>
    	<td>${project.domainProject.nameDomain}</td>
    </tr>
    <tr>	
    	<th>Creation date:</th>
    	<td>${project.dateCreationP}</td>
    </tr>
   <!--  <tr>
       	
    </tr>
 	<tr>
 		
 	</tr>
 	<tr>
 		
	</tr> -->
</table>

<table border=1px align="center">
	<tr style="padding:10px;">
		<td style="padding:10px; text-align:center" >
			<a href="${pageContext.request.contextPath}/project/add.html">
				<img border="0" alt="image" title="Add new project" src= "<c:url value='/resources/images/add-button.png'/>" width="30" height="30"/>
        	</a>
        </td>
		<td style="padding:10px; text-align:center">
			<a href="${pageContext.request.contextPath}/project/edit/${project.id}.html">
				<img border="0" alt="image" title="Edit project" src= "<c:url value='/resources/images/edit-button.png'/>" width="25" height="25"/>
			</a>
		</td>
		<td style="padding:10px; text-align:center">
			<a href="${pageContext.request.contextPath}/project/delete/${project.id}.html">
				<img border="0" alt="image" title="Delete project" src= "<c:url value='/resources/images/delete-button.png'/>" width="25" height="25"/>
			</a>
		</td>
	</tr>
</table>

</div>


<p><a href="${pageContext.request.contextPath}/assign-user-project.html">Assign user to project</a></p>

<strong><a href="${pageContext.request.contextPath}/index.html">Back to page</a></strong>

</body>
</html>