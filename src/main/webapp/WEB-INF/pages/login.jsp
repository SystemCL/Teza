<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link href= >
<!--   <link rel="stylesheet" href="style1.css"> -->
  <title>Register user page</title>
  <style>
      <%@ include file="style1.css"%>
  </style>
  
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body onload='document.login.username.focus();'>
<div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
      
        <div id="signup">
          
          <h1>Sign Up for Free</h1>
          
          <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/registration.html" >
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Username<span class="req">*</span>
              </label>
              <input type="text" name="username" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Password<span class="req">*</span>
              </label>
              <input type="password" name="password" required autocomplete="off"/>
            </div>
          </div>

          
          <button type="submit" class="button button-block">Get Started</button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </form:form>
		
        </div>
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          <c:if test="${not empty error}">
			<div class="error">${error}</div>
		  </c:if>
		  <c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		  </c:if>
          
          <form action="<c:url value='/login' />" method="POST">
          
            <div class="field-wrap">
            <label>
              Username<span class="req">*</span>
            </label>
            <input type='text' name='username' required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name='password' required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
          	<input id="remember_me" name="remember-me" type="checkbox"/>Remember me
          </div>
          
          
<!--           <p class="forgot"><a href="#">Forgot Password?</a></p> -->
          
          <button class="button button-block" type='submit'>Log In</button>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          
          </form>
            
        </div>
        
      </div><!-- tab-content -->
      <p style="position: fixed; bottom: 0; font-color: black; padding-bottom: 3%;"><a href="${pageContext.request.contextPath}/index.html"><b>Back to Home Page</b></a></p>
</div> <!-- /form -->

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <!--  <script src="javascript/index1.js"></script> -->
   <script src="${pageContext.request.contextPath}/resources/javascript/index1.js" ></script>
</body>
</html>