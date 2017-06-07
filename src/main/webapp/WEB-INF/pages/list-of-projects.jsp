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
<title>List of projects</title>
<style>
    <%@ include file="table.css"%>
</style>
</head>
<body>
<h2>List of projects</h2>
<jsp:include page="header.jsp" />
<p>Here you can see the list of the projects, edit them or remove.</p>

<div class="showListDiv" style="height:150px;overflow:auto;">
<table class="table1" border="2px" cellpadding="0" cellspacing="0" align="center" width="750">
<thead>

<tr bgcolor="#dbf0db">
<th width="3%">id</th><th width="5%">Nom</th><th width="5%">Domain</th><th width="5%">Date Creation</th><th width="2%">Actions</th>
</tr>
</thead>
<tbody>

<c:forEach var="project" items="${projects}" varStatus="status">
<tr onclick="window.document.location='#';">
	<td align="center">${project.id}</td>
	<td>${project.nomProject}</td>
	<td align="center">${project.domainProject.nameDomain}</td>
		<td>${project.dateCreationP}</td> 
   <%--  <td align="center">${project.created}</td>  --%>
	<%-- <td align="center">${project.dateCreationP}</td> --%>
	<td width="5%" >
	<a href="${pageContext.request.contextPath}/project/edit/${project.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/project/delete/${project.id}.html">Delete</a><br/>
	</td>
</tr>


</c:forEach>
 
</tbody>
</table>
</div>

<script>
function submitSearchForm() {
	var searchString = $("#searchTerm").val();
	if(searchString == null || searchString.replace(/^\s+|\s+$/g, '') == "") {
		alert("You must enter some search words");
	} else {
		$("#searchForm").submit();
		$(document).ready(function() {
		    $('.table1 th').hide();
		    
		});
		//$( "div.showListDiv" ).replaceWith( $( ".showSearchDiv" ) );
		
	}
}


</script>
<% 
      if(request.getParameter("searchResult") == null) {
%>
<div class="showSearchDiv" style="height:190px;overflow:auto; margin-top: -129px;"  >    	 
<table class="table2" id="searchTable" border="2px" align="center" cellpadding="2" cellspacing="0" width="750"  >
<!-- 	<thead>
		<tr bgcolor="#dbf0db">
			<th width="3%">id</th><th width="5%">Nom</th><th width="5%">Domain</th><th width="5%">Date Creation</th><th width="2%">Actions</th>
		</tr>
	</thead> -->
	<tbody>
		<c:forEach var="project" items="${searchResult}" varStatus="status" >
		<tr onclick="window.document.location='#';">
	    <td align="center" width="13.2%">${project.id}</td>
		<td width="22.2%">${project.nomProject}</td>
		<td align="center" width="24.9%">${project.domainProject.nameDomain}</td>
		<td>${project.dateCreationP}</td> 
   <%--  <td align="center">${project.created}</td> 
	<td align="center">${project.dateCreationP}</td>  --%>
		<td width="14.3%" >
		<a href="${pageContext.request.contextPath}/project/edit/${project.id}.html">Edit</a><br/>
	    <a href="${pageContext.request.contextPath}/project/delete/${project.id}.html">Delete</a><br/>
	</td>
</tr>



</c:forEach>
</tbody>
</table>
</div>

<%} else {
	
} %>      

<p><a href="${pageContext.request.contextPath}/assign-user-project.html">Assign user to project</a></p>

<strong><a href="${pageContext.request.contextPath}/index.html">Back to page</a></strong>

</body>
</html>