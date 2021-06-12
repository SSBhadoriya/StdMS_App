 <%@include file="header.jsp" %>   
<!DOCTYPE html>
<body style="background:#f7e6ff;">
<div class="container mt-5">
 <div class="row">
 	<div class="col-lg-4"></div>
 	<div class="col-lg-4 offset-4">
<% String msg=(String)request.getAttribute("msg");
 if(msg!=null){%>
<div class="alert alert-danger alert-dismissible">
 <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong><%out.print(msg);%></strong>
</div>
<%}%>


<h1 style="color:voilet;background:#66b3ff;text-align: center;">Login Form</h1><hr/>
<form action="./controller" method="post">
<div class="form-group">
 <label for="userid"><b>User Id:</b></label>
    <input type="text" class="form-control" placeholder="Enter Id" name="uid" id="userid" required><br/>

    <label for="pwd"><b>Password</b></label>
    <input type="password" class="form-control" placeholder="Enter Password" name="pass" id="pwd" required><br/>
	
    <label for="usr">Login as:</label>
    <select class="form-control" id="usr" name="user" required>
      <option value="" disabled="disabled" selected="selected">-Select user type-</option>
      <option>Administration</option>
     <!--  <option>Organization</option>
      <option>Job Seeker</option>
      <option>Student</option> -->
      
    </select><br><br>
<button type="submit" class="btn btn-success"/>Login</button>
<button type="reset" class="btn btn-danger"/>Reset</button>
</div>
</form>
</div>
</div>
</div>
</body>
