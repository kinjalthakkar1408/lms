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

    /* Style the action buttons */
    .action-btn {
        font-size: 18px;
        color: #007bff;
        background-color: transparent;
        border: none;
        cursor: pointer;
        margin: 0 5px;
    }

    /* Change button color on hover */
    .action-btn:hover {
        color: #0056b3;
    }
    
   .add-publisher-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}
	#add-publisher-form{
		display : none;
	}
	
    </style>

</head>
</head>
<body>
<!-- <form action="/lms/addPublisher" method="get" > -->
	<div class="container">
		<table class="book-table">
			<tr>
				<th>Publisher Name</th>
				<th>View</th>
				<th>Update</th>
				<th>Delete</th>
				
			</tr>
			<!-- Populate table with publisher data -->
			<tbody>
			    <c:forEach var="publishers" items="${publishers}">
			      <tr>
			        <td>${publishers.publisherName}</td>
					<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
					<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
					<td><a class="btn btn-danger"><i class="fas fa-user-times ml-2"></i></a></td>
			      </tr>
		    </c:forEach>
		  </tbody>
			<!-- Add more rows for additional books -->
		</table>
		<div class="btn-container">
			<button class="add-book-btn" onClick="showPublisherForm()">Click to add a new Publisher</button>
		</div>
		
		<br>
		
		<div id ="add-publisher-form">
			<form>
				<div class="form-group" >
					<label for="publishername">Publisher Name:</label>
					<input type="text" class="form-control" id="publishername" name="publishername" autofocus required>
				</div>
					<button type="submit" class="btn btn-primary" onClick="addPublisher()">Add Publisher</button>
			</form>
		</div>
	</div>
<script>
	function showPublisherForm(){
		var showForm = document.getElementById("add-publisher-form");
		showForm.style.display="block"; 
	}
	function addPublisher(){
		document.getElementById("add-publisher-form").style.display = "none";
	}
</script>
<!-- </form> -->
</body>
</html>
