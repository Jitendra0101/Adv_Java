<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player-Form</title>
</head>
<body>
<form action="addPlayer.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Enter date-of-birth</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting-Average</td>
				<td><input type="number" name="battingAvg" /></td>
			</tr>
			<tr>
				<td>Enter Wickets Taken</td>
				<td><input type="number" name="wicketsTaken" /></td>
			</tr>
			<tr>
				<td>Enter Team Id</td>
				<td><input type="number" name="teamId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register-Team" /></td>
			</tr>
		</table>
	</form>
</body>
</html>