<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style>
     <%@ include file="MenuStyle.css"%>
</style>
<%-- <link href="<c:url value="/MenuStyle.css" />" rel="stylesheet"> --%>
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<jsp:include page="header.jsp" />
<p>
${message}<br/>
</p>
<h2 align="center">Welcome to home page: ${pageContext.request.userPrincipal.name}</h2>
<table align="left" border="1">
	<tr>
		<td>
		<p>
			<a href="https://www.w3schools.com">
<img border="0" src= "/images/tickets.png" width="200" height="200"/>
</a>
</p>
		</td>
		<td>
		123
		</td>
	</tr>
</table>

</body>
</html>