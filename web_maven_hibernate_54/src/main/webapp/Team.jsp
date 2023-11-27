<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team-Form</title>
</head>
<body>

	<form action="addTeam.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Team name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Team Abbreviation</td>
				<td><input type="text" name="abbreviation" /></td>
			</tr>
			<tr>
				<td>Enter owner</td>
				<td><input type="text" name="owner" /></td>
			</tr>
			<tr>
				<td>Enter Max Age</td>
				<td><input type="number" name="maxAge" /></td>
			</tr>
			<tr>
				<td>Enter Min batting average</td>
				<td><input type="number" name="minBattingAvg" /></td>
			</tr>
			<tr>
				<td>Enter Min wickets taken</td>
				<td><input type="number" name="minWicketsTaken" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register-Team" /></td>
			</tr>
		</table>
	</form>
</body>
</html>