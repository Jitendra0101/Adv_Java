<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="player" class="beans.PlayerBean" scope="session"/>
<jsp:useBean id="team" class="beans.TeamBean" scope="session"/>
<jsp:setProperty property="*" name="player"/>
<body>
<h4> status : ${sessionScope.player.addNewPlayer()}</h4>
</body>
</html>