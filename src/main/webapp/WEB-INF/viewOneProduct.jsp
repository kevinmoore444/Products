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
<body>
	<div class="content">
		<h3>Categories associated with ${product.productName}</h3>

		<c:forEach var="eachCategory" items="${assignedCategories}">
			<p><c:out value="${eachCategory.categoryName}"/></p>
		</c:forEach>
		<br/>
		<form action="/product/${id}" method="post">
		<h4>Add Product:</h4>
		<select name="categoryId" id="categoryId" class="input">
			<c:forEach var="eachCategory" items="${unassignedCategories}">
				<option value="${eachCategory.id}">${eachCategory.categoryName}</option>
			</c:forEach>
		</select>
		<input class="input" class="button" type="submit" value="Add"/>
		</form>
		<p><a href="/dashboard">Home</a></p>
	</div>
</body>
</body>
</html>