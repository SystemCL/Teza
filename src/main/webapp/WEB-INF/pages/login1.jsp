<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
    <%@ include file="LoginStyle.css"%>
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<div id="login-box">

		<!-- <h3>Login with Username and Password</h3> -->

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' action="<c:url value='/login' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>

<tr>
<td><input id="remember_me" name="remember-me" type="checkbox"/>Remember me</td>
<!-- <td><label for="remember_me" class="form-control">Remember me</label></td> -->
</tr>
				<tr>
					<td align="right" colspan='2'><input name="submit"
						type="submit" value="Login" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
<p><a href="${pageContext.request.contextPath}/index.html">Back to Home Page</a></p>
<p align="right"><a href="${pageContext.request.contextPath}/registration.html">Register</p>
		</form>
	</div>

</body>
</html>