<?xml version="1.0" encoding="ISO-8859-1" ?>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
     <%@ include file="MenuStyle.css"%>
</style>
</head>
<body>
	
 <ul>

   <li><a class="active" href="${pageContext.request.contextPath}/index.html">Home</a></li>
   <li class="dropdown">
     <a href="${pageContext.request.contextPath}/project/list.html" class="dropbtn">Projects</a>
       <div class="dropdown-content">
          <a href="${pageContext.request.contextPath}/project/add.html">Add Project</a>
          <a href="${pageContext.request.contextPath}/project/list.html">Project List</a>
       </div>
   </li>
   
   <li class="dropdown">
     <a href="${pageContext.request.contextPath}/ticket/list.html" class="dropbtn">Tickets</a>
       <div class="dropdown-content">
          <a href="${pageContext.request.contextPath}/ticket/add.html">Add Ticket</a>
          <a href="${pageContext.request.contextPath}/ticket/list.html">Ticket List</a>
       </div>
   </li>
   
   <li class="dropdown">
     <a href="${pageContext.request.contextPath}/utilisateur/list.html" class="dropbtn">Utilisateurs</a>
       <div class="dropdown-content">
          <a href="${pageContext.request.contextPath}/utilisateur/add.html">Add Utilisateur</a>
          <a href="${pageContext.request.contextPath}/utilisateur/list.html">Utilisateurs List</a>
       </div>
   </li>

<c:if test="${pageContext.request.userPrincipal.name != null}">
<li><a style="padding-right:20px" class="active" onclick="return confirm('Are you sure you want to LogOut?')" href="${pageContext.request.contextPath}/logout">Logout</a></li>

</c:if>

<c:if test="${pageContext.request.userPrincipal.name == null}">
<li><a style="padding-right:20px" class="active" href="${pageContext.request.contextPath}/login"><font color="#F59C6E" size="3px"><b>Login</b></font></a></li>
</c:if>

 </ul>

</body>
</html>