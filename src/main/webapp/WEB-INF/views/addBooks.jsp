<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- Custom CSS -->
	<link rel="stylesheet" type="text/css" href="style.css">
    <style>
    body {
		margin: 0;
		padding: 0;
	}

    </style>
</head>
<body>
		<div>
		<div class="container mt-4">
		<h2><center>Add Book</center></h2>
		<form>
			<div class="form-group">
				<label for="bookname">Book Name:</label>
				<input type="text" class="form-control" id="bookname" name="bookname" autofocus required>
			</div>
			<div class="form-group">
				<label for="isbn">ISBN:</label>
				<input type="text" class="form-control" id="isbn" name="isbn" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description" required></textarea>
			</div>
			<div class="form-group">
				<label for="author">Author:</label>
				<select class="form-control" id="author" name="author" required>
					<option value="">--Select--</option>
					<option value="1">John Doe</option>
					<option value="2">Jane Doe</option>
				</select>
			</div>
			<div class="form-group">
				<label for="category">Category:</label>
				<select class="form-control" id="category" name="category" required>
					<option value="">--Select--</option>
					<option value="1">Fiction</option>
					<option value="2">Non-Fiction</option>
				</select>
			</div>
			<div class="form-group">
				<label for="publisher">Publisher:</label>
				<select class="form-control" id="publisher" name="publisher" required>
					<option value="">--Select--</option>
					<option value="1">Fiction</option>
					<option value="2">Non-Fiction</option>
				</select>
			</div>
			<div class="form-group">
				<label for="noofcopies">No. of Copies:</label>
				<input type="number" class="form-control" id="noofcopies" name="noofcopies" min="1" required>
			</div>
			<button type="submit" class="btn btn-primary">Add Book</button>
		</form>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<!-- Custom JS -->
	<script type="text/javascript" src="script.js"></script>
</body>
</html>
