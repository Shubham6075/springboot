<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee List</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<style>
a{
color: white;
}
a:hover {
color: white;
text-decoration: none;
}
</style>
<body>

	<div class="container">

		<h1 class="p-3">Employees List</h1>

		<form:form>
			<table class="table table-bordered">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Gender</th>
					<th>Department Id</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach var="employee" items="${empList}">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.email}</td>
						<td>${employee.dob}</td>
						<td>${employee.gender}</td>
						<td>${employee.dep.id}</td>
						<td><button type="button" class="btn btn-success">
								<a href="/editEmployee/${employee.id}">Edit</a>
							</button></td>
						<td><button type="button" class="btn btn-danger">
								<a href="/deleteEmployee/${employee.id}">Delete</a>
							</button></td>
					</tr>
				</c:forEach>

			</table>
		</form:form>

		<button type="button" class="btn btn-primary btn-block">
			<a href="/addEmployee">Add New Employee</a>
		</button>

	</div>

</body>
</html>