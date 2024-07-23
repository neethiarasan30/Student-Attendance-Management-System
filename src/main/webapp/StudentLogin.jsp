<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="Login.css">

</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="StudentValidationServlet" onsubmit="return myfunction()">
            <table>
                <tr>    
                    <td><input type="text" placeholder="Roll No" name="rollno" required/></td>
                </tr>
                <tr>
                    <td><input type="password" placeholder="Password" name="password" required/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
   
            </table>
        </form>
    </div>
   
</body>
</html>
