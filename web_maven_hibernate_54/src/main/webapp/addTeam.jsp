<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Team</title>
<jsp:setProperty property="*" name="team"/>
</head>
<body>
<h4> status : ${sessionScope.team.addTeam()}</h4>
</body>
</html>