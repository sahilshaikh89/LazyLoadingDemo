<%@page import="com.lazyload.model.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="css/foundation.min.css" rel="stylesheet" /> 
<title>Submitted Records</title>
</head>
<body>
	<h3>Submitted Records</h3>
	<div class="small-12 large-12 columns">
		<table>
			<thead>
				<tr>
					<th>User Id</th>
					<th>Person Name</th>
					<th>Address</th>
					<th>Selected Hobby</th>
					<th>Remarks</th>
				</tr>
			</thead>
			<tbody>
		<% 
			ArrayList<Person> personList = (ArrayList<Person>) request.getAttribute("personList");
		
			for(Person p : personList){
		%>
				<tr>
					<td><%= p.getUserId() %></td>
					<td><%= p.getPersonName() %></td>
					<td><%= p.getAddress() %></td>	
					<td><%= p.getSelectedHobby() %></td>	
					<td><%= p.getRemarks() %></td>			
				</tr>
		
		<% } %>
			</tbody>
		</table>
	</div>
	
	<h5>
		<a href="lazyLoad.htm">GO BACK</a>
	</h5>
</body>
</html>