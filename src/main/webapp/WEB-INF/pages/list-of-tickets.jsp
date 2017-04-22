<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of tickets</title>
</head>
<body>
<h1>List of tickets</h1>
<jsp:include page="header.jsp" />
<p>Here you can see the list of the tickets, edit them or remove.</p>

<div style="height:190px;overflow:auto;">
<table border="2px" cellpadding="0" cellspacing="0" align="center" width="750">
<thead>

<!-- private String nomTicket;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy.MM.dd")
	@Column(name = "dateCreationT")
	private Date dateCreationT;
	@Column(name = "sujetTicket")
	private String sujetTicket;
	@Column(name = "etatTicket")
	private String etatTicket; -->
<tr bgcolor="#dbf0db">
<th width="3%">id</th><th width="5%">Nom</th><th width="5%">Date Creation</th><th width="2%">Sujet</th><th width="2%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="ticket" items="${tickets}">
<tr>
 	<td align="center">${ticket.id}</td> 
	<td>${ticket.nomTicket}</td>
	<td>${ticket.dateCreationT}</td>
	<td align="center">${ticket.sujetTicket}</td>
	<td width="5%" >
	<a href="${pageContext.request.contextPath}/ticket/edit/${ticket.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/ticket/delete/${ticket.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<p><a href="${pageContext.request.contextPath}/index.html">Back to page</a></p>

</body>
</html>