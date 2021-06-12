<%@include file="header.jsp" %>   
<!DOCTYPE html>
<body style="background:#f7e6ff;">
<div class="container">
 <div class="row">
 	<div class="col-lg-4"></div>
 	<div class="col-lg-4 offset-4">
<!--Restricting user to open page via link or back button using session   -->
<% String user=(String)session.getAttribute("user");
 if(user==null){
	response.sendRedirect("index.jsp");
}%>

<% String msg=(String)request.getAttribute("msg"); 
if(msg!=null){%>
<div class="alert alert-warning alert-dismissible">
 <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%out.print(msg);%></strong>
</div>
<%}%>	
<%-- <%@page import="com.stdms.model.StudentBin" %>
<%StudentBin sb=(StudentBin)request.getAttribute("STUDENT"); %> --%>
<h2 style="color:voilet;background:#66b3ff;text-align: center;">Create Student Record</h2><hr/>
<form action="./CreateaAction" method="post">
<div class="form-group">
 <label for="userid" class="hidden"><b>User Id:</b></label>
    <input type="hidden" class="form-control" placeholder="Enter Enrollment no." name="uid" id="userid" 
    	
    ><br/>

    <label for="name"><b>User Name:</b></label>
    <input type="text" class="form-control" placeholder="Enter Candidate's name" name="uname" id="name" required
    	
    ><br/>
	
	<label for="father"><b>Father/Guardian Name</b></label>
    <input type="text" class="form-control" placeholder="Enter Father's or Guardian's name" name="fname" id="father" required
    	
    ><br/>
    
    <label for="email"><b>Email ID:</b></label>
    <input type="email" class="form-control" placeholder="Enter Email ID" name="email" id="email" required
    
    ><br/>
    
    <label for="address"><b>Address:</b></label>
    <textarea class="form-control" placeholder="Address" name="add" id="address" required
    	
    ></textarea><br/>
    
<button type="submit" class="btn btn-success"/>Save</button>
<button type="reset" class="btn btn-danger"/>Reset</button>
</div>
</form>
</div>
</div>
</div>
</body>