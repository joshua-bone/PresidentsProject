<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel= "stylesheet" href="styleSheet.css"></>

<title>Presidents</title>
</head>
<body>
<h2> ${dao.name}</h2>
<h2> ${dao.party}</h2>
<h2> ${dao.term}</h2>
<h2> ${dao.fact}</h2>
<form action="presidents.do" method="POST">
	<button name="navigate" value="back">Back</button>
	<img src="${dao.imgURL}" width="300"/>
	<button name="navigate" value="forward">Forward</button>
	<br>
	<input type="number" name="term"/>
	<button name="navigate" value="getTerm">Get Term</button>
</form>
</body>
</html>