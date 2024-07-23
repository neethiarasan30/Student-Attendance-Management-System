<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Faculty</title>
<link rel="stylesheet" type="text/css" href="AddFaculty.css">

</head>
<body>
    <div class="container">
        <h1>Add Faculty</h1>
        <form action="AddFaculty" onsubmit="return myfunction()" method="post">
            <table>
             	<tr>    
                   <td><input type="text"  placeholder="EmployeeID" name="employeeid" required/></td>
                </tr>
                <tr>    
                    <td><input type="text"  placeholder="Staff Name" name="username" required/></td>
                </tr>
                 <tr>
                    <td><input type="text"  placeholder="EmailId" name="email" required/></td>
                </tr>
                <tr>
                    <td><input type="password"  placeholder="Password" name="password" required/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Add"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
