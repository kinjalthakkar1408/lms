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
	<div class="container">
		<table class="book-table">
			<thead>
				<tr>
	              	<th>Issuance ID</th>
	              	<th>Student ID</th>
		            <th>Student Name</th> 
		            <th>Book Name</th>
		            <th>Issued Date</th>
		            <th>Return Date</th>
				</tr>
			</thead>
	    <tbody>
	        <c:forEach items="${issuances}" var="issuance">
	            <tr>
	                <td>${issuance.id}</td>
	                <td>${issuance.student.studentId}</td>
	                <td>${issuance.student.firstName}</td> 
	                <td>${issuance.book.bookName}</td>
	                <td>${issuance.issueDate}</td>
	                <td>${issuance.returnDate}</td>

	            </tr>
	        </c:forEach>
    	</tbody>
	</table>
	</div>
	
</body>
</html>
