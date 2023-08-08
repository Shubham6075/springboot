<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<div class="container">
		<h1 class="p-3">Edit Employee</h1>

		<form:form action="/editSaveEmployee" modelAttribute="emp" method="post">
			<div class="row">
				<div class="form-group col-md-12">
					<div class="col-md-6">
						<form:hidden path="id" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="firstName">First Name</label>
					<div class="col-md-6">
						<form:input type="text" path="firstName" id="firstName"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="lastName">Last Name</label>
					<div class="col-md-6">
						<form:input type="text" path="lastName" id="lastName"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="gender">Gender</label>
					<div class="col-md-6" class="form-control input-sm">

						<div class="form-check form-check-inline">
							<form:radiobutton class="form-check-input" path="gender"
								value="Male" required="required" />
							<label class="form-check-label" for="inlineRadio1">Male</label>
						</div>
						<div class="form-check form-check-inline">
							<form:radiobutton class="form-check-input" path="gender"
								value="Female" />
							<label class="form-check-label" for="inlineRadio2">Female</label>
						</div>
						<div class="form-check form-check-inline">
							<form:radiobutton class="form-check-input" path="gender"
								value="Other" />
							<label class="form-check-label" for="inlineRadio3">Other</label>
						</div>

					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="dob">Date of birth</label>
					<div class="col-md-6">
						<form:input type="date" path="dob" id="dob"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="email">Email</label>
					<div class="col-md-6">
						<form:input type="email" path="email" id="email"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<div class="col-md-6" class="form-control input-sm">
						<div class="form-group">
							<label for="sel1">Select Department:</label>
							<form:select class="form-control" path="dep.id">
								<c:forEach items="${dep}" var="d">
									<option value="${d.id}"><c:out value="${d.name}" /></option>
								</c:forEach>
							</form:select>
						</div>

					</div>
				</div>
			</div>

			<div class="row p-2">
				<div class="col-md-2">
					<button type="submit" value="Register" class="btn btn-success">Update</button>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>