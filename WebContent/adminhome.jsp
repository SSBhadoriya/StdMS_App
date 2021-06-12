<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:#a64dff;">
<!--Restricting user to open page via link or back button using session   -->
<% String user=(String)session.getAttribute("user");
 if(user==null){
	response.sendRedirect("index.jsp");
}%>
<div class="container">
<div class="jumbotron">
  <h1 class="display-4">Administration Home</h1>
  <p class="lead"></p>
  <hr class="my-4">
  <p>It is used to perform <b>C</b>reate, <b>R</b>ead, <b>U</b>pdate and <b>D</b>elete <b>(CRUD)</b> operation on record(s).</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="ReadMe.html" target="_blank" role="button">Read more</a>
  </p>
</div>
</div>
</body>
</html>