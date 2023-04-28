<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common-header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Store</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
    
    <style>
    
    body {
		margin: 0;
		padding: 0;
	}

	/* Set container width and center align */
	.container {
		width: 80%;
		margin: 0 auto;
		padding-top: 50px;
	}
	
		/* Style the "Add Book" button */
	.add-book-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}

	/* Change button color on hover */
	.add-book-btn:hover {
		background-color: #0056b3;
	}

	/* Clearfix for button container */
	.btn-container::after {
		content: "";
		clear: both;
		display: table;
	}
	
		/* Change button color on hover */
	.add-book-btn:hover {
		background-color: #0056b3;
	}
    
    .add-student-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}
	#add-student-form{
		display : none;
	}
	
	select {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: none;
        margin-bottom: 20px;
        font-size: 16px;
    }
	
    </style>

</head>
</head>
<body>
<div class="container">
	<table class="book-table">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Email Id</th>
			<th>Gender</th>
			<th>Department</th>
			
			<th>View</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<!-- Populate table with books data -->
		<tbody>
			 <c:forEach var="students" items="${students}">
			     <tr>
			        <td>${students.firstName}</td>
			        <td>${students.lastName}</td>
			        <td>${students.username}</td>
			        <td>${students.email}</td>
			        <td>${students.gender}</td>
			        <td>${students.department}</td>
			        
					<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
					<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
					<td><a class="btn btn-danger"><i class="fas fa-user-times ml-2"></i></a></td>
			     </tr>
		    </c:forEach>
		  </tbody>
		
		
<!-- 		<tr>
			<td>Kinjal </td>
			<td>Thakkar </td>
			<td>kinjalthakkar14 1</td>
			<td>kinjalthakkar14@gmail.com</td>
			<td>female</td>
			<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
			<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
			<td><a class="btn btn-danger"><i class="fas fa-user-times ml-2"></i></a></td>
		</tr> -->
		<!-- Add more rows for additional books -->
	</table>
	<div class="btn-container">
		<button class="add-student-btn" onClick="showStudentForm()">Click to add a new Student</button>
	</div>

	<br>

	<div id ="add-student-form">
		<form>
			<div class="form-group" >
				<label for="firstname">First Name:</label>
				<input type="text" class="form-control" id="firstname" name="firstname" autofocus required>
			</div>
			<div class="form-group" >
				<label for="lastname">Last Name:</label>
				<input type="text" class="form-control" id="lastname" name="lastname"  required>
			</div>
			<div class="form-group" >
				<label for="username">Username:</label>
				<input type="text" class="form-control" id="username" name="username"  required>
			</div>
			<div class="form-group" >
				<label for="password">Password :</label>
				<input type="password" class="form-control" id="password" name="password"  required>
			</div>
			<div class="form-group" >
				<label for="email">Email Id :</label>
				<input type="email" class="form-control" id="email" name="email"  required>
			</div>
			
			<div class="form-group" >
				<div class="radio-group">
			        <label>Gender : </label>
			        <label for="male">
			          <input type="radio" id="male" name="gender" value="male"> Male
			        </label>
			        <label for="female">
			          <input type="radio" id="female" name="gender" value="female"> Female
			        </label>
			        <label for="other">
			          <input type="radio" id="other" name="gender" value="other"> Other
			        </label>
		      	</div>
		      </div>
		      
		     <div class = "form-group">
				<label for="birthday">Birthday:</label>
  				<input type="date" id="birthday" name="birthday">
			 </div>
		      
		      <div class="form-group">
				<label for="course">Course:</label>
				<select class="form-control" id="course" name="course" required>
					<option value="COMPUTER_SCIENCE">Computer Science</option>
					<option value="INFORMATION_SYSTEM">Information System</option>
					<option value="MECHANICAL_ENGINEERING">Mechanical Engineering</option>
					<option value="CIVIL_ENGINEERING">Civil Engineering</option>
				</select>
			 </div>
			 
			 <div class="form-group">
				<label for="department">Department:</label>
				<select class="form-control" id="department" name="department" required>
					<option value="COE">COE</option>
					<option value="CPS">CPS</option>
					<option value="DAMG">DAMG</option>
				</select>
			 </div>
		      
			<button type="submit" class="btn btn-primary" onClick="addStudent()">Add Student</button>
		</div>
		</form>
	</div>
</div>
<script>
	function showStudentForm(){
		var showForm = document.getElementById("add-student-form");
		showForm.style.display="block"; 
	}
	function addStudent(){
		document.getElementById("add-student-form").style.display = "none";
	}
</script>
</body>
</html>
