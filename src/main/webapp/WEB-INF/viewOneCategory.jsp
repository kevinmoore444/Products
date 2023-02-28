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
	<div class="content">
		<h3>Products associated with ${category.categoryName}</h3>

		<c:forEach var="eachProduct" items="${assignedProducts}">
			<p><c:out value="${eachProduct.productName}"/></p>
		</c:forEach>
		<br/>
		<form action="/category/${id}" method="post">
		<h4>Add Product:</h4>
		<select name="productId" id="productId" class="input">
			<c:forEach var="eachProduct" items="${unassignedProducts}">
				<option value="${eachProduct.id}">${eachProduct.productName}</option>
			</c:forEach>
		</select>
		<input class="input" class="button" type="submit" value="Add"/>
		</form>
		<p><a href="/dashboard">Home</a></p>
	</div>
</body>
</html>