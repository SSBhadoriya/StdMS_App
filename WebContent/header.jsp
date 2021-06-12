<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  
  <!--Session pragma and cache control code here  -->
  <%
 	response.addHeader("pragma","no-cache");
	response.addHeader("cache-control","no-store");
	response.addHeader("expire","0");
  %>
</head>
<body>
<%! String user; %> 
<%	user=(String)session.getAttribute("user");
%>
<nav class="navbar navbar-dark bg-success">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Record Management System</a>
    </div>
    <%if(user!=null){%>
    <ul class="nav navbar-nav">
      <li class="active"><a href="adminhome.jsp" class="glyphicon glyphicon-home"> Home</a></li>
      <li><a href="createnewstudent.jsp">Create New Record<span></span></a>
       <!--  <ul>
          <li><a href="createnewstudent.jsp">Create Single Record</a></li>
          <li><a href="createbulkstudent.jsp">Create Bulk Record</a></li>
        </ul> -->
      </li>
      <li><a href="./ViewAction">View All Record</a></li>
    </ul>
   <%}%>
    <ul class="nav navbar-nav navbar-right">
    <% if(user!=null){%>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 
		<%out.println(user); %>
		</a></li>
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
       <%}else{%>
        <li><a href="#"><span class="glyphicon glyphicon-registration-mark"></span> New Registration</a></li>
        <%} %>
    </ul>
  </div>
</nav>

</body>
</html>
