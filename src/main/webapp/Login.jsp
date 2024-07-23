<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="Login.css">
<script type="text/javascript">
    function myfunction() {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        if (username == "") {
            alert("Username cannot be empty");
            return false;
        } else if (password == "") {
            alert("Password cannot be empty");
            return false;
        }
    }
</script>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="Validation" onsubmit="return myfunction()">
            <table>
                <tr>    
                    <td><input type="text" id="username" placeholder="Username" name="username"/></td>
                </tr>
                <tr>
                    <td><input type="password" id="password" placeholder="Password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form>
    </div>
   
</body>
</html>
