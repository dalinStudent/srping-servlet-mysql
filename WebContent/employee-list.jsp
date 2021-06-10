<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Employee Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        </head>

        <body>

            <div class="container mt-5">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success mb-3">Add New</a>
				<table class="table table-bordered text-center">
				  <thead>
				    <tr>
				      <th>ID</th>
				      <th>First Name</th>
				      <th>Last Name</th>
				      <th>Gender</th>
				      <th>Email</th>
				      <th>Province</th>
				      <th>Action</th>
				    </tr>
				  </thead>
				  <tbody>
				   <c:forEach var="employee" items="${listEmployee}">
					    <tr>
					    	<td><c:out value="${employee.id}" /></td>
					      	<td><c:out value="${employee.firstName}" /></td>
					      	<td><c:out value="${employee.lastName}" /></td>
					      	<td><c:out value="${employee.gender}" /></td>
					      	<td><c:out value="${employee.email}" /></td>
					      	<td><c:out value="${employee.province}" /></td>
					      <td>
					      	<a href="edit?id=<c:out value='${employee.id}' />" class="material-icons">edit</a>
					      	<a href="delete?id=<c:out value='${employee.id}' />" class="material-icons">delete</a>
					      </td>
					     </tr>	
				    </c:forEach>	  
				  </tbody>
				</table>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
        </body>

        </html>