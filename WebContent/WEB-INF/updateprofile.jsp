<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  

</head>
<body style="background:#DADEBC;">
<nav class="navbar navbar-dark bg-danger">
<div class="container-fluid">
    <div class="navbar-header">
       <a class="navbar-brand" href="#">Student Management System</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
    
        <li><a href="index.jsp"><span class="glyphicon glyphicon-step-backward"></span> Go-back to Home</a></li>
     </ul>	
</div>
</nav>

<div class="container mt-5">
 <div class="row">
 	<div class="col-lg-4"></div>
 	<div class="col-lg-4 offset-4">
<h1 style="color:voilet;background:#04B45E;text-align: center;">-:Update Profile:-</h1><hr/>
<form action="./RegistrationAction" method="post">
<div class="form-group">
 	<label for="username"><b>Candidate Name:</b></label>
    <input type="text" class="form-control" placeholder="Enter your name" name="uname" id="username" required><br/>

    <label for="pwd"><b>Password</b></label>
    <input type="password" class="form-control" placeholder="Enter Password" name="pass" id="pwd" required><br/>

	<label for="username"><b>Candidate Name:</b></label>
    <input type="text" class="form-control" placeholder="Enter your name" name="uname" id="username" required><br/>

    <label for="pwd"><b>Password</b></label>
    <input type="password" class="form-control" placeholder="Enter Password" name="pass" id="pwd" required><br/>
	
	
<button type="submit" class="btn btn-success"/>Update</button>

</div>
</form>
</div>
</div>
</div>
</body>
</html>