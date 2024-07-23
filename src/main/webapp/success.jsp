<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.StudentAttendance"%> <!-- Replace with your actual package name -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" type="text/css" href="success.css">
</head>
<body>
    <header>
        <h1>Attendance Submitted Successfully</h1>
    </header>
    
    <div class="container">
        <form action="SaveToDatabaseServlet" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>RollNo</th>
                        <th>Attendance</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<StudentAttendance> attendanceList = (ArrayList<StudentAttendance>) session.getAttribute("attendanceList");
                        if (attendanceList != null) {
                            for (StudentAttendance student : attendanceList) {
                    %>
                    <tr>
                        <td><%= student.getName() %></td>
                        <td><%= student.getRollno() %></td>
                        <td><%= student.getAttendance() %></td>
                        <td><%= student.getDate() %></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <input type="submit" value="Save to Database">
        </form>
    </div>

</body>
</html>
