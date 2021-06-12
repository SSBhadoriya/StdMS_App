<%
	session.invalidate();	//Destroy the object and setAttribute method
	response.sendRedirect("index.jsp");
%>