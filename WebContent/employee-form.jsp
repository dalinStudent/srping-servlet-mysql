<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Employee Management Application</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container col-md-5 mt-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${employee != null}">
                     <form action="update" method="post">
                </c:if>
                <c:if test="${employee == null}">
                     <form action="insert" method="post">
                </c:if>
					<caption>
                       <h2>
                         <c:if test="${employee != null}">
                            Edit Employee
                         </c:if>
                         <c:if test="${employee == null}">
                            Add New Employee
                         </c:if>
                       </h2>
                     </caption>

                        <c:if test="${employee != null}">
                            <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text" value="<c:out value='${employee.firstName}' />" class="form-control" name="firstName" required="required">
                        </fieldset>
                        
						<fieldset class="form-group">
                            <label>Last Name</label> <input type="text" value="<c:out value='${employee.lastName}' />" class="form-control" name="lastName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Gender</label> <input type="text" value="<c:out value='${employee.gender}' />" class="form-control" name="gender" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${employee.email}' />" class="form-control" name="email" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Province</label> <input type="text" value="<c:out value='${employee.province}' />" class="form-control" name="province" required="required">
                        </fieldset>
                        
						<a href="<%=request.getContextPath()%>/list" class="btn btn-danger float-right">Back</a>
                        <button type="submit" class="btn btn-success">Save</button>
                        
                </form>
           </div>
       </div>
    </div>
</body>
</html>