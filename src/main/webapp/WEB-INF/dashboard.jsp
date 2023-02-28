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
		<h1>Home Page</h1>
		<a href="/product/new"><button>New Product</button></a>
		<a href="/category/new"><button>New Category</button></a>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Products</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="eachProduct" items="${productList}">
					<tr>
						<td><a href="/product/${eachProduct.id}"><c:out value="${eachProduct.productName}"/></a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table class="table table-striped">
			<thead>
				<tr>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="eachCategory" items="${categoryList}">
				<tr>
					<td><a href="/category/${eachCategory.id}"><c:out value="${eachCategory.categoryName}"/></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>