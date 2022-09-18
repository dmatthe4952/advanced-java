<html>
<head>
<meta>
<title>Post</title>
<style>
	form {
		border: 1px solid gray;
		width: 350px;
		margin-right: auto;
		margin-left: auto;
		margin-top: 200px;
		padding: 30px;
		display: grid;
		grid-template-columns: 1fr, 1fr;
		grid-gap: 0.5em, 0.5em;
	}
	
	label {
		place-self: end;
	}
	
	#submit {
		grid-column: 2/3;
	}
	
</style>
</head>
<body>
	<form method='POST' action=HelloWorld>
		<label for="name">Name:</label><input type="text" name="name" id="name" />
		<label for="password">Password:</label><input type="password" name="password" id="password" />
		<button id="submit">Submit</button>
	</form>
</body>
</html>