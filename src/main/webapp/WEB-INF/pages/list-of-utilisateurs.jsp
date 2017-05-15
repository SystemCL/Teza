<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of utilisateurs</title>
<style>
    <%@ include file="table.css"%>
</style>
</head>
<body>
<h1>List of utilisateurs</h1>
<jsp:include page="header.jsp" />
<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Here you can see the list of the utilisateurs, edit them or remove.</p>

<div style="height:190px;overflow:auto;">
<table border="2px" cellpadding="0" cellspacing="0" align="center" width="750">
<thead>
<tr bgcolor="#dbf0db">
<th width="3%">id</th><th width="5%">FirstName</th><th width="5%">LastName</th><th width="2%">Age</th><th width="2%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="utilisateur" items="${utilisateurs}">
<tr>
	<td align="center">${utilisateur.id}</td>
	<td>${utilisateur.firstName}</td>
	<td>${utilisateur.lastName}</td>
	<td align="center">${utilisateur.age}</td>
	<td width="5%" >
	<a href="${pageContext.request.contextPath}/utilisateur/edit/${utilisateur.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/utilisateur/delete/${utilisateur.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
  <h3>Only Admin can view utilisateurs!</h3>
</sec:authorize>
<sec:authorize access="isAnonymous()">
<br/><h3 style="padding-left: 20px;">For view utilisateurs, please login first as Admin.</h3>
</sec:authorize>

<p><a href="${pageContext.request.contextPath}/index.html">Back to page</a></p>

</body>
</html>