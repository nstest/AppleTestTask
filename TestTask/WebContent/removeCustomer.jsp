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
	<div class="container">
		<form class="form" action="removeCustomer" method="post">
		<span class="message" style="color:red">${message}</span><br /><br />
			<label><b>First Name:</b><br />
			<input type="text" id="firstName" name="firstName"
				placeholder="First Name"></input></label> <br /> <label><b>Last
					Name:</b><br />
			<input type="text" id="lastName" name="lastName"
				placeholder="Last Name"></input></label> <br /> <label><b>Date
					of Birth:</b><br />
			<input type="text" id="birthDate" name="birthDate"
				placeholder="YYYY-MM-DD"></input></label> <br /> <input type="Submit"
				id="submit" class="submit" />

		</form>
		<button onclick="location.href='index.jsp';" id="home" class="home">Home</button>
	</div>
</body>
</html>