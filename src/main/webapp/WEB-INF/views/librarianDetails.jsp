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
    
    .add-librarian-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}
	#add-librarian-form{
		display : none;
	}
	
	input[type="radio"] {
        margin-right: 10px;
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
			
			<th>View</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<!-- Populate table with books data -->
		<tbody>
		<c:forEach var="librarian" items="${librarian}">
			     <tr>
			        <td>${librarian.firstName}</td>
			        <td>${librarian.lastName}</td>
			        <td>${librarian.username}</td>
			        <td>${librarian.email}</td>
			        <td>${librarian.gender}</td>
			        
					<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
					<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
					<td><a class="btn btn-danger"><i class="fas fa-user-times ml-2"></i></a></td>
			     </tr>
		    </c:forEach>
		  </tbody>
		<!-- Add more rows for additional books -->
	</table>
	<div class="btn-container">
		<button class="add-librarian-btn" onClick="showLibrarianForm()">Click to add a new Librarian</button>
	</div>

	<br>

	<div id ="add-librarian-form">
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
		      <div class="form-group" >

	      </div>
				<button type="submit" class="btn btn-primary" onClick="addLibrarian()">Add Librarian</button>
		</form>
	</div>
</div>
<script>
	function showLibrarianForm(){
		var showForm = document.getElementById("add-librarian-form");
		showForm.style.display="block"; 
	}
	
	function addLibrarian(){
		document.getElementById("add-librarian-form").style.display = "none";
	}
</script>
</body>
</html>
