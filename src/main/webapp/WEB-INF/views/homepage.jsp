<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="common-header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Library Store</title>

<!-- Bootstrap JS -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<!-- Custom JS -->
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

.add-book-btn {
	background-color: #007bff;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 20px;
}

#add-book-form {
	display: none;
}

#update-book-form {
	display: none;
}
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
</head>
<body>

	<div class="container">
		<table class="book-table">
			<thead>
				<tr>
					<th>Book Name</th>
					<th>ISBN</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Category</th>
					<th>Description</th>
					<!-- 				<th>Availability</th> -->
					<th>No. of Copies</th>
					<th>View</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody id="bookTableBody">
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.bookName}</td>
						<td>${book.isbn}</td>
						<td>${book.author.authorName}</td>
						<td>${book.publisher.publisherName}</td>
						<td>${book.category.categoryName}</td>
						<td>${book.description}</td>
						<%-- 			        <td>${book.availability}</td> --%>
						<td>${book.noOfcopies}</td>
						<td><a class="btn btn-info"><i class="fas fa-marker ml-2"></i></a></td>
						<td><a class="btn btn-warning"
							onclick="populate('${book.id}')"><i
								class="fas fa-user-edit ml-2"></i></a></td>
						<td><a class="btn btn-danger delete-btn"
							onclick="deleteBook('${book.id}')"><i
								class="fas fa-user-times ml-2"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>

			<!-- Add more rows for additional books -->
		</table>
		<div class="btn-container">
			<button class="add-book-btn" onClick="showBookForm()">Click
				to add a new Book</button>
		</div>

		<br>

		<div id="add-book-form">
			<form>
				<div class="form-group">
					<label for="bookName">Book Name:</label> <input type="text"
						class="form-control" id="bookName" name="bookName" autofocus
						required>
				</div>

				<div class="form-group">
					<label for="isbn">ISBN:</label> <input type="text"
						class="form-control" id="isbn" name="isbn" required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label>
					<textarea class="form-control" id="description" name="description"
						required></textarea>
				</div>

				<div class="form-group">
					<label for="author">Author:</label> <select class="form-control"
						id="author" name="author" required>
						<option value="">--Select--</option>
						<c:forEach var="authors" items="${authors}">
							<option value="${authors.id}">${authors.authorName}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="category">Category:</label> <select
						class="form-control" class="form-control" id="category"
						name="category" required>
						<option value="">--Select--</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.id}">${category.categoryName}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="publisher">Publisher:</label> <select
						class="form-control" id="publisher" name="publisher" required>
						<option value="">--Select--</option>
						<c:forEach var="publishers" items="${publishers}">
							<option value="${publishers.id}">${publishers.publisherName}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="noOfcopies">No. of Copies:</label> <input type="number"
						class="form-control" id="noOfcopies" name="noOfcopies" min="1"
						required>
				</div>

				<button type="submit" class="btn btn-primary" onClick="addBook()">Add
					Book</button>
			</form>
		</div>

		<div id="update-book-form">
			<form>
				<div>
					<center>
						<h1>Update Book Details</h1>
					</center>
				</div>
				<div class="form-group">
					<label for="bookName">Book Name:</label> <input type="text"
						class="form-control" id="bookName" name="bookName" autofocus
						required>
				</div>

				<div class="form-group">
					<label for="isbn">ISBN:</label> <input type="text"
						class="form-control" id="isbn" name="isbn" required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label>
					<textarea class="form-control" id="description" name="description"
						required></textarea>
				</div>

				<%-- 			<div class="form-group">
					<label for="author">Author:</label> <select class="form-control"
						id="author" name="author" required>
						<option value="">--Select--</option>
						<c:forEach var="authors" items="${authors}">
							<option value="${authors.id}">${authors.authorName}</option>
						</c:forEach>
					</select>
				</div> --%>

				<%-- 			<div class="form-group">
					<label for="category">Category:</label> <select
						class="form-control" class="form-control" id="category"
						name="category" required>
						<option value="">--Select--</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.id}">${category.categoryName}</option>
						</c:forEach>
					</select>
				</div> --%>

				<%-- 				<div class="form-group">
					<label for="publisher">Publisher:</label> <select
						class="form-control" id="publisher" name="publisher" required>
						<option value="">--Select--</option>
						<c:forEach var="publishers" items="${publishers}">
							<option value="${publishers.id}">${publishers.publisherName}</option>
						</c:forEach>
					</select>
				</div> --%>

				<div class="form-group">
					<label for="noOfcopies">No. of Copies:</label> <input type="number"
						class="form-control" id="noOfcopies" name="noOfcopies" min="1"
						required>
				</div>

				<button type="submit" class="btn btn-primary"
					onClick="updateBook('${book.id}')">Update Book</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		function showBookForm() {
			var showForm = document.getElementById("add-book-form");
			showForm.style.display = "block";
		}

		function addBook() {

			// Get the form data
			var formData = {
				bookName : $("#bookName").val(),
				isbn : $("#isbn").val(),
				description : $("#description").val(),
				author : {
					id : parseInt($("#author").val())
				},
				publisher : {
					id : parseInt($("#publisher").val())
				},
				category : {
					id : parseInt($("#category").val())
				},
				availability : true,
				noOfcopies : parseInt($("#noOfcopies").val())
			/*   role: "Admin" */
			};
			console.log(formData);
			// Send the AJAX request

			// Send the AJAX request
			$.ajax({
				type : "POST",
				url : "/lms/home/createBook",
				data : JSON.stringify(formData),
				contentType : "application/json",
				success : function(data) {
					window.location.reload();
					// Display success message
					alert("Book added successfully!");

				},
				error : function(xhr, status, error) {
					// Handle the error response from the server
					alert("Error: " + error);
				}
			});

			document.getElementById("add-book-form").style.display = "none";
		}

		function populate(book) {
			var showForm = document.getElementById("update-book-form");
			showForm.style.display = "block";
			console.log(book);

			var isbnInput = document.getElementById("isbn");
			isbnInput.value = book;

			console.log(book)
			isbnInput.disabled = true;

			alert(document.getElementById('isbn'));

			//  $('#isbn').val(book.isbn);
			/*  $('#isbn').prop('disabled', true); */
			document.getElementById('isbn').value = book;
			/*   $('#description').val(book.description);

			$('#noOfcopies').val(book.noOfcopies); */
		}

		function updateBook(bookId) {
			alert("update called");

			var bookName = $("#bookName").val();
			// var isbn = $("#isbn").val();
			var description = $("#description").val();
			/* 	  var author = $("#author").val();
				  var publisher = $("#publisher").val();
				  var category = $("#category").val(); */
			var noOfcopies = $("#noOfcopies").val();

			var bookData = {
				"bookName" : bookName,
				// "isbn": isbn,
				"description" : description,
				/* 			    "author": {
				 "id": author
				 },
				 "publisher": {
				 "id": publisher
				 },
				 "category": {
				 "id": category
				 }, */
				"noOfcopies" : noOfcopies
			};

			$.ajax({
				type : "PUT",
				contentType : "application/json",
				url : "/lms/home/update/" + bookId,
				data : JSON.stringify(bookData),
				dataType : 'json',
				success : function(data) {
					window.location.reload();
				},
				error : function(xhr, textStatus, errorMessage) {
					// handle error scenario
				}
			});
		}

		function deleteBook(bookId) {
			alert(bookId);
			$.ajax({
				type : "DELETE",
				url : "/lms/home/deleteBook/" + parseInt(bookId),
				success : function(data) {
					// Refresh the page after deletion
					$("#bookTableBody").html(data);
					window.location.reload();
				},
				error : function(xhr, status, error) {
					console.log("Error while deleting author: " + error);
				}
			});
		}
	</script>
</body>
</html>
