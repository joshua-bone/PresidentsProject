<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Presidents</title>
</head>
<body>
<h2> ${dao.name}</h2>
<form action="presidents.do" method="POST">
	<button name="navigate" value="back">Back</button>
	<img src="https://upload.wikimedia.org/wikipedia/commons/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg" width="100"/>
	<button name="navigate" value="forward">Forward</button>
	<br>
	<input type="number" name="term"/>
	<button name="navigate" value="getTerm">Get Term</button>
</form>
</body>
</html>