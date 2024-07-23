<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link rel="stylesheet" type="text/css" href="AddStudent.css">
</head>
<body>
    <div class="container">
        <h1>Add Student</h1>
        <form action="AddStudent" method="post">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Roll No</th>
                    <th>Password</th>
                    <th>Mail ID</th>                    
                </tr>
                <tr>
                    <td><input type="text" name="name" placeholder="Name" required></td>
                    <td><input type="text" name="rollno" placeholder="Roll No" required></td>
                    <td><input type="text" name="password" placeholder="Password" required></td>
                    <td><input type="email" name="mailid" placeholder="Mail ID" required></td>
                    <td><input type="submit" value="Add"></td>                            
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
