<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
		<div class="container mt-5">
			<h1>New Category</h1>
			<form:form action="/category/new" method="post" modelAttribute="newCategory" class="form" >
			    <p>
			        <form:label path="categoryName">Name:</form:label>
			        <form:input path="categoryName" class="form-control"/>
			        <form:errors path="categoryName"/>
			    </p>
			    <button class="btn btn-primary" type="submit" value="Submit">Submit</button>
			</form:form>
		</div>  
</body>
</html>