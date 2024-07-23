<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Attendance</title>
<link rel="stylesheet" type="text/css" href="MarkAttendance.css">
</head>
<body>
    <header>
        <h1>Mark Student Attendance</h1>
    </header>
    
    <form action="AttendanceServlet" method="post">
        <label for="attendanceDate">Date:</label>
        <input type="date" id="attendanceDate" name="attendanceDate" required>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>RollNo</th>
                    <th>Present</th>
                    <th>Absent</th>
                </tr>
            </thead>
            <tbody>
                <%  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMS", "root", "80155");  
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Student;");
                
                while (rs.next()) {
                    String name = rs.getString("name");
                    String rollno = rs.getString("rollno");
                %>
                <tr>
                    <td><input type="text" value="<%=name %>" disabled></td>    
                    <td><input type="text" value="<%=rollno %>" disabled></td>
                    <td><input type="radio" name="attendance_<%=rollno %>" value="Present"></td>
                    <td><input type="radio" name="attendance_<%=rollno %>" value="Absent"></td>
                    <input type="hidden" name="name_<%=rollno %>" value="<%=name %>">
                    <input type="hidden" name="rollno_<%=rollno %>" value="<%=rollno %>">
                </tr>
                <% } %>
            </tbody>
        </table>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
