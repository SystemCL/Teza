<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style>
     <%@ include file="MenuStyle.css"%>

img {
	max-width: 100%;
}

</style>
<%-- <link href="<c:url value="/MenuStyle.css" />" rel="stylesheet"> --%>
<title>Home page</title>
</head>
<body>
<h2>Home page</h2>
<jsp:include page="header.jsp" />
<p>
${message}<br/>
</p>
<h2 align="center">Welcome to home page: ${pageContext.request.userPrincipal.name}</h2>
<!-- <div id="dateDiv" style="position:relative"> today</div>  -->
<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
<table border="0" align="center">
	<tr>
		<td style= "border-radius:40px;" class="proj"  >
		<p>
			<a href="${pageContext.request.contextPath}/project/list.html">
<img border="0" alt="image" title="View project list" src= "<c:url value='/resources/images/projects_icon.png'/>" width="200" height="200" />

<%-- ${pageContext.request.contextPath}/tickets.png --%>
</a>
</p>
		</td>
		<td style= "border-radius:40px;" class="tick" align="center">
			<a href="${pageContext.request.contextPath}/ticket/list.html">
<img border="0" alt="image" title="View ticket list" src= "<c:url value='/resources/images/tickets.png'/>" width="200" height="200"/>

<%-- ${pageContext.request.contextPath}/tickets.png --%>
</a>
		</td>
	</tr>
	<tr >
		<td align="center">
		Projects
		</td>
		<td align="center">
		Tickets
		</td>
	</tr>
</table>
<jsp:include page="datepage.jsp" />
</sec:authorize>
</body>
</html>