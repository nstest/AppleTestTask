<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grid Dynamics: A Test Task</title>
<link rel="stylesheet" type="text/css" href="style/master.css" />
</head>
<body>
	<h1>Test Task</h1>
	<hr>
	<br /><br />
	<div class="container">
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connect = null;

		String host = "127.0.0.1:3306";
		String databaseName = "testtask";
		String user = "root";
		String passwd = "password";
	%>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date of Birth</th>
			<th>Phone Number</th>
			<th>Email</th>
		</tr>
		<%
			try {
				Class.forName("com.mysql.jdbc.Driver");

				// Setup the connection with the DB
				connect = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/testtask", "root",
						"password");

				// Statements allow to issue SQL queries to the database
				statement = connect.createStatement();

				String strQuery = "select * from testtask.customer";
				resultSet = statement.executeQuery(strQuery);
				while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("first_name")%></td>
			<td><%=resultSet.getString("last_name")%></td>
			<td><%=resultSet.getString("birth_date")%></td>
			<td><%=resultSet.getString("phone")%></td>
			<td><%=resultSet.getString("email")%></td>
		</tr>
		<%
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	</div>
	<button onclick="location.href='index.jsp';" id="home" class="home">Home</button>
</body>
</html>