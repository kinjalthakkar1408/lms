<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common-header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Store</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
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
    
    .add-author-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}
	#add-author-form{
		display : none;
	}	
	
    </style>
</head>
</head>
<body>
<!-- <form action="/lms/author" method="get" > -->
	<div class="container">
		<table class="book-table">
			<tr>
				<th>Author Name</th>
				<th>Description</th>
				<th>View</th>
				<th>Update</th>
				<th>Delete</th>
				
			</tr>
			<!-- Populate table with books data -->
			
			<tbody>
			    <c:forEach var="authors" items="${authors}">
			      <tr>
			        <td>${authors.authorName}</td>
			        <td>${authors.description}</td>
					<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
					<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
					<td><a class="btn btn-danger delete-btn" onclick="deleteAuthor('${authors.id}')" ><i class="fas fa-user-times ml-2"></i></a></td>
			      </tr>
			    </c:forEach>
		  </tbody>
			
			
<!-- 			<tr>
				<td>Author 1</td>
				<td>Author Description</td>
				<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
				<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
				<td><a class="btn btn-danger delete-btn"><i class="fas fa-user-times ml-2"></i></a></td>
			</tr> -->
			<!-- Add more rows for additional books -->
		</table>
		<div class="btn-container">
			<button class="add-book-btn" onClick="showAuthorForm()">Add Author</button>
		</div>
		
		<br>

		<div id ="add-author-form">
			<form>
				<div class="form-group" >
					<label for="authoryname">Author Name:</label>
					<input type="text" class="form-control" id="authorname" name="authorname" autofocus required>
				</div>
				
				<div class="form-group">
					<label for="description">Description:</label>
					<textarea class="form-control" id="description" name="description" required></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary" onClick="addAuthor()">Click to add a new Author</button>
			</form>
		</div>
</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		function showAuthorForm(){
			var showForm = document.getElementById("add-author-form");
			showForm.style.display="block"; 
		}
		function addAuthor(){
			document.getElementById("add-author-form").style.display = "none";
		}
		
		  function deleteAuthor(authorId) {
			  alert(authorId);
			    $.ajax({
			      type: "DELETE",
			      url: "/lms/author/deleteAuthor/" + authorId,
				console.log(url);
			      success: function(data) {
			        // Refresh the page after deletion
			        location.reload();
			      },
			      error: function(xhr, status, error) {
			        console.log("Error while deleting author: " + error);
			      }
			    });
			  }
	</script>
	
	
<!-- </form> -->
</body>
</html>
