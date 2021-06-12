
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@page import="com.stdms.model.StudentBin" %>
<% StudentBin sb=(StudentBin)request.getAttribute("UPDATE");%>
</head>
<body>
<div class="container">
 <div class="row">
 	<div class="col-lg-4"></div>
 	<div class="col-lg-4 offset-4">
 	<% String UPDATION=(String)request.getAttribute("UPDATION");
 if(UPDATION!=null){%>
<div class="alert alert-success alert-dismissible">
 <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%out.print(UPDATION);%></strong>
</div>
<%}%>
 	
<h2 style="color:voilet;background:#66b3ff;text-align: center;">Update Student Record</h2><hr/>
<form action="./UpdateActionForm" method="post">
<div class="form-group">
 <label for="userid"><b>Roll No.:</b></label>
    <input type="text" class="form-control" placeholder="Enter Enrollment no." name="roll_no" id="userid" 
    	<%if(sb!=null){ %>
    		value="<%= sb.getId()%>"
    	<%} %>
    ><br/>

    <label for="name"><b>User Name:</b></label>
    <input type="text" class="form-control" placeholder="Enter Candidate's name" name="sname" id="name" required
    	<%if(sb!=null){ %>
    		value="<%= sb.getSname()%>"
    	<%} %>
    ><br/>
	
	<label for="father"><b>Father/Guardian Name</b></label>
    <input type="text" class="form-control" placeholder="Enter Father's or Guardian's name" name="fname" id="father" required
    	<%if(sb!=null){ %>
    		value="<%= sb.getFname()%>"
    	<%} %>
    ><br/>
    
    <label for="email"><b>Email ID:</b></label>
    <input type="email" class="form-control" placeholder="Enter Email ID" name="email" id="email" 
    	<%if(sb!=null){ %>
    		value="<%= sb.getEmail()%>"
    	<%} %>
    ><br/>
    
     <label for="pass"><b>Password:</b></label>
    <input type="text" class="form-control" name="password" id="pass" 
    	<%if(sb!=null){ %>
    		value="<%= sb.getPassword()%>"
    	<%} %>
    ><br/>
    
    <label for="address"><b>Address:</b></label>
    <textarea class="form-control" placeholder="Address" name="address" id="address">
    <%if(sb!=null){ %><%=sb.getAddress()%><%} %></textarea><br/>
    
<button type="submit" class="btn btn-success"/>Save</button>

</div>
</div>
</div>
</div>
</form>

</body>
</html>