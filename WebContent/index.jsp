<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="styleSheet.css">

<title>Presidents</title>
</head>
<body>

	<c:if test="${not empty filter}">
		<h6>filtering by pattern "${filter}"</h6>
	</c:if>
	
 	<h3>${dao.nthTerm}</h3>
	<h2>${dao.name}</h2>
	<h2>${dao.party}</h2>
	<h2>${dao.term}</h2>

	<div class="presidentImage">
		<img src="${dao.imgURL}" width="400" />
		<form action="presidents.do" method="POST">
			<button name="navigate" value="back">Back</button>
			<button name="navigate" value="forward">Forward</button>
			<input type="number" name="term" />
			<button name="navigate" value="getTerm">Get Term</button>
		</form>
	</div>
	
	<div class="presidentFact">
		<p>${dao.fact}</p>
		<form action="presidents.do" method="POST">
		<input type="text" name="filter" />
		<button name="navigate" value="filterText">Set Filter</button>
		</form>
	</div>
	
	<form action="presidents.do" method="POST">
	<c:set var="count" value="0" scope="page"/>
	<c:forEach var="p" items="${dao.presidents}" varStatus="counter">
<button class="fancyButton" name="thumbnail" value="${count}"><img src="${p.imgURL}" width="100"></button>
<c:set var="count" value="${count + 1 }" scope="page"/>
</c:forEach>
</form>
	
	<br />
	<br />
	<br /> 

</body>
</html>