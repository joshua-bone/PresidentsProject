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

	<div class="presidentImage"><img src="${dao.imgURL}" width="300"/></div>
	<div class="presidentFact"><p> ${dao.fact}</p></div>


<form action="presidents.do" method="POST">
	<button name="navigate" value="back">Back</button>
	<button name="navigate" value="forward">Forward</button>
	<input type="number" name="term"/>
	<button name="navigate" value="getTerm">Get Term</button>
</form>

</body>
</html>