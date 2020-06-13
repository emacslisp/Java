<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="/action_page.php">
	<div>
	    <label for="username">Username:</label>
	    <input type="text" id="username" name="username">
	</div>
	
	<div>
	    <label for="pass">Password (8 characters minimum):</label>
	    <input type="password" id="pass" name="password"
	           minlength="8" required>
	</div>
	
	<input type="submit" value="Sign in">
</form> 

</body>
</html>