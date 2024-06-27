<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
 <link rel="stylesheet" href="styles.css">

</head>
<body>
<h1> Welcome to the Registration page</h1>
<form action="regForm" method="post">
Name:<input type="text" name="name1"/> <br/> 
Email:<input type="text" name="email1"/> <br/> 
Password:<input type="password" name="Pass1"/> <br/>
Gender:<input type="radio" name="gender1" value="Male"/>Male<input type="radio" name="gender1" value="Female"/>Female<br/>


City: <select name="city1">
<option>Select City</option>
<option>Delhi</option>
<option>Mumbai</option>
<option>Pune</option>
<option>Banglore</option>
</select><br><br>

<button type="submit" value="Register">Register</button>
<p><a href="index.html">Back to Home</a></p>
</form>
</body>
</html>