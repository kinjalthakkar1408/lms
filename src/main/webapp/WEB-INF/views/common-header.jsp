<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Store</title>
    	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
    <style>
        /* Reset default margin and padding for body */
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

/* Set heading font style and center align */
h1 {
	font-size: 24px;
	font-weight: bold;
	text-align: center;
}

/* Style the horizontal navigation bar */
.nav {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #f2f2f2;
}

.nav li {
	float: left;
}

.nav li a {
	display: block;
	color: #333;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.nav li a:hover {
	background-color: #ddd;
}

/* Style the book table */
.book-table {
	width: 100%;
	margin-top: 20px;
	border-collapse: collapse;
}

.book-table th, .book-table td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

.book-table th {
	background-color: #f2f2f2;
}
.logout{
	float: right;
    /* margin: 16px; */
    background-color: #007bff;
    padding: 14px;
    color: white;
}
    

    </style>
</head>
<body>
	<div class="container">
	<div>
		<h1>Welcome ${firstname} to the Library Store</h1>
		<a href="/lms/logout" class="logout">logout</a>
	</div>
		<ul class="nav">
		
		<c:if test="${role == 'Admin'}">
			<li><a href="/lms/home">Books</a></li>
			<li><a href="/lms/author">Authors</a></li>
			<li><a href="/lms/publisher">Publishers</a></li>
			<li><a href="/lms/category">Category</a></li>
			<li><a href="/lms/librarian">Librarian</a></li>
			<li><a href="/lms/student">Student</a></li>
			<li><a href="/lms/issuances">Issuances</a></li>
		</c:if>
		
		<c:if test="${role == 'Student'}">
			<li><a href="/lms/home/bookListAvailable">Books</a></li>
			<li><a href="/lms/home/students/getIssuances">Issuances</a></li>
			<li><a href="/lms/student">Update Profile</a></li>

		</c:if>
		
		<c:if test="${role == 'Librarian'}">
			<li><a href="/lms/home">Books</a></li>
			<li><a href="/lms/author">Authors</a></li>
			<li><a href="/lms/publisher">Publishers</a></li>
			<li><a href="/lms/category">Category</a></li>
			<li><a href="/lms/student">Student</a></li>
			<li><a href="/lms/librarian/displayAllIssuances">Issuances</a></li>
		</c:if>
		
		

		</ul>
	</div>
</body>
</html>
