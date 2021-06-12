<!DOCTYPE html>
<%@include file="header.jsp" %>   
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
</head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.css"/>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.js"></script>
<body>
<script>

function deleteRec(id)
{
	/* alert(id) */ 
	
	 swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this data!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
		   
		      window.location.assign('./DeleteStudentAction?roll_no='+id)
		  } else {
		    swal("Your Record is safe!");
		  }
		}); 
}


$(document).ready(function () 
{
    $('#myTable').DataTable();
    
    
});
</script>



<!--Restricting user to open page via link or back button using session   -->
<% String user=(String)session.getAttribute("user");
 if(user==null){
	response.sendRedirect("index.jsp");
	
}%>


<div class="container">
	<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12">
  <h2 style="color:voilet;background:#66b3ff;text-align: center;">View All Records</h2>
  <p>Now Records can be Search, Edit and Delete on few clicks...</p>            
 <%
String m=(String)request.getAttribute("DELETE");
if(m!=null)
{
%>
<div class="alert alert-danger alert-dismissible">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>
  <% out.println(m); %>
  </strong>
</div>
<%}%>

  <table class="table table-striped" id="myTable">
    <thead>
      <tr>
        <th>Sr no.</th>
        <th>Person Name</th>
        <th>Father's Name</th>
        <th>Email ID</th>
        <th>Password</th>
        <th>Address</th>
        <th>Delete</th>
        <th>Edit</th>
      </tr>
    </thead>
    <tbody>
      <%@page import="java.util.List,com.stdms.model.StudentBin" %>
      <%List<StudentBin> list=(List<StudentBin>) request.getAttribute("STUDENT"); 
 for(StudentBin sb:list)
 {
 %>
      <tr>
        <td><%=sb.getId()%></td>
        <td><%=sb.getSname()%></td>
        <td><%=sb.getFname()%></td>
        <td><%=sb.getEmail()%></td>
        <td><%=sb.getPassword()%></td>
        <td><%=sb.getAddress()%></td>
        <%-- <td><a href="./DeleteStudentAction?roll_no=<%=sb.getId()%>" id="deleteByRoll" class="glyphicon glyphicon-trash"></a></td> --%>
       <td><a href="#" onclick="deleteRec(<%=sb.getId()%>)" class="glyphicon glyphicon-trash"></a></td>
       <td><a href="./UpdateStudentAction?roll_no=<%=sb.getId()%>" id="updateByRoll" class="glyphicon glyphicon-pencil"></a></td>       
      </tr>
  <%}%>
    </tbody>
  </table>
</div>
</div>
</div>
</body>
</html>