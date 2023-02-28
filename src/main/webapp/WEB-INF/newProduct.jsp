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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body>
		<div class="container mt-5">
			<h1>New Product</h1>
			<form:form action="/product/new" method="post" modelAttribute="newProduct" class="form" >
			    <p>
			        <form:label path="productName">Name:</form:label>
			        <form:input path="productName" class="form-control"/>
			        <form:errors path="productName"/>
			    </p>
			    <p>
			        <form:label path="description">Description:</form:label>
			        <form:input  path="description" class="form-control"/>
			        <form:errors path="description"/>
			    </p>
			    <p>
			        <form:label path="price">Price:</form:label>
			        <form:input type="number" path="price" class="form-control"/>
			        <form:errors path="price"/>
			    </p>
			    <button class="btn btn-primary" type="submit" value="Submit">Submit</button>
			</form:form>
		</div>  
</body>
</html>