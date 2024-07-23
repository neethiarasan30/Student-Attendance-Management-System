<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<link rel="stylesheet" type="text/css" href="StudentDetails.css">
</head>
<body>
    <header>
        <h1>Student Attendance Details</h1>
    </header>
    <div class="container">
        <table>
            <tr>
                <th>Attendance</th>
                <th>Date</th>
            </tr>
            <% 
            String rollno = (String)session.getAttribute("rollno");  
            
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMS", "root", "80155");  
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Attendance where rollno='" + rollno + "' order by date;");
            %>
            <h1>Roll No: <%=rollno %></h1>
            <% 
            while(rs.next()) {
                String name = rs.getString("name");
                String rollnodb = rs.getString("rollno");
                String attendance = rs.getString("attendance");
                String date = rs.getString("date");
            %>    
                <tr>
                    <td><%=attendance%></td>
                    <td><%=date%></td>
                </tr>
            <% 
            }
            %>
        </table>
    </div>
  
</body>
</html>
