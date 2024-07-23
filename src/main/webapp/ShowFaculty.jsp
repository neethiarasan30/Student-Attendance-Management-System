<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Details</title>
<link rel="stylesheet" type="text/css" href="ShowFaculty.css">
</head>
<body>
    <header>
        <h1>Faculty Details</h1>
    </header>
    <div class="container">
        <table>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th>Email</th>
            </tr>
            <% 
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/SAMS","root","80155");  
            java.sql.Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from faculty;");
            
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("username");
                String email = rs.getString("email");
            %>    
                <tr>
                    <td><%=id%></td>
                    <td><%=name%></td>
                    <td><%=email%></td>                
                </tr>
            <% 
            }
            %>
        </table>
    </div>
</body>
</html>
