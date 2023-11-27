<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add New Player</title>
<jsp:setProperty property="*" name="player"/>
</head>
<body>
<h4> status : ${sessionScope.player.addNewPlayer()}</h4>
</body>
</html>