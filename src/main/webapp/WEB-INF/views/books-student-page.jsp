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

.issuebook{
    background-color: #007bff;
    color: white;
}
</style>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
</head>
<body>
	<!-- <form action="/lms/addBooks" method="get" > -->
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
					<th>Availability</th>
					<th>No. of Copies</th>
					<th>Action</th>

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
						
				        <td>
				            <c:choose>
				                <c:when test="${book.availability == true}">Yes</c:when>
				                <c:otherwise>No</c:otherwise>
				            </c:choose>
				        </td>	
						<td>${book.noOfcopies}</td>
						      <td><c:if test="${book.availability == true}">
       								<button class="issuebook" onClick="issueBook(${book.id})">Issue Book</button>
					        </c:if>
					        <c:if test="${book.availability == false}">
					          <button class="issuebook" onClick="issueBook(${book.id})" disabled>Issue Book</button>
					        </c:if>
      					</td>
					</tr>
				</c:forEach>
			</tbody>

			<!-- Add more rows for additional books -->
		</table>
	</div>
	<!-- </form> -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		function issueBook(bookId) {
			alert("issue")
			  const today = new Date();
			  const returnDate = new Date(today.getTime() + (15 * 24 * 60 * 60 * 1000)); // add 15 days to the current date
			  const data = JSON.stringify({
			    book: {
			      id: bookId
			    },
			    issueDate: today.toISOString().slice(0, 10),
			    returnDate: returnDate.toISOString().slice(0, 10) // set the return date
			  });

			  $.ajax({
			    type: 'POST',
			    url: 'students/'+${loggedInUser.id}+'/issuances',
			    contentType: 'application/json',
			    data: data,
			    success: function(response) {
			      alert('Book issued successfully!');
			      location.reload();
			    },
			    error: function(xhr, textStatus, errorThrown) {
			      alert('Error issuing book: ' + xhr.responseText);
			    }
			  });
			}
	</script>
</body>
</html>
