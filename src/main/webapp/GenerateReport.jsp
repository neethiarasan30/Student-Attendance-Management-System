<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Report</title>
<link rel="stylesheet" type="text/css" href="GenerateReport.css">
</head>
<body>
    <header>
        <h1>Generate Attendance Report</h1>
    </header>
    
    <div class="container">
        <form action="GenerateReportServlet" method="post">
            <label for="reportDate">Enter Date:</label>
            <input type="date" id="reportDate" name="reportDate" required>
            <input type="submit" value="Generate Report">
        </form>
    </div>
    
    <footer>
        <p>&copy; 2024 SAMS. All rights reserved.</p>
    </footer>
</body>
</html>
