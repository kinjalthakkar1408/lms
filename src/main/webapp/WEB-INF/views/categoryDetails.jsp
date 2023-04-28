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
    
    .add-category-btn {
		background-color: #007bff;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		margin-top: 20px;
	}
	#add-category-form{
		display : none;
	}
	
    </style>

</head>
</head>
<body>
<div class="container">
	<table class="book-table">
		<tr>
			<th>Category Name</th>
			<th>View</th>
			<th>Update</th>
			<th>Delete</th>
			
		</tr>
		<!-- Populate table with category data -->
			<tbody>
			    <c:forEach var="category" items="${category}">
			      <tr>
			        <td>${category.categoryName}</td>
					<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
					<td><a class="btn btn-warning"><i class="fas fa-user-edit ml-2"></i></a></td>
					<td><a class="btn btn-danger"><i class="fas fa-user-times ml-2"></i></a></td>
			      </tr>
		    </c:forEach>
		  </tbody>
		<!-- Add more rows for additional books -->
	</table>
	<div class="btn-container">
		<button class="add-book-btn" onClick="showCategoryForm()">Click to add a new Category</button>
	</div>

	<br>

	<div id ="add-category-form">
		<form>
			<div class="form-group" >
				<label for="categoryname">Category Name:</label>
				<input type="text" class="form-control" id="categoryname" name="categoryname" autofocus required>
			</div>
				<button type="submit" class="btn btn-primary" onClick="addCategory()">Add Category</button>
		</form>
	</div>
</div>
<script>
	function showCategoryForm(){
		var showForm = document.getElementById("add-category-form");
		showForm.style.display="block"; 
	}
	function addCategory(){
		document.getElementById("add-category-form").style.display = "none";
	}
</script>
</body>
</html>
