package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentAttendance;

@WebServlet("/SaveToDatabaseServlet")
public class SaveToDatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<StudentAttendance> attendanceList = (ArrayList<StudentAttendance>) request.getSession().getAttribute("attendanceList");

        if (attendanceList != null && !attendanceList.isEmpty()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAMS", "root", "80155");
                
                String query = "INSERT INTO Attendance (name, rollno, attendance, date) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);

                for (StudentAttendance student : attendanceList) {
                    pstmt.setString(1, student.getName());
                    pstmt.setString(2, student.getRollno());
                    pstmt.setString(3, student.getAttendance());
                    pstmt.setString(4, student.getDate());
                    pstmt.addBatch();
                }

                pstmt.executeBatch();
                con.close();

                // Clear the list after saving to the database
                attendanceList.clear();
                request.getSession().setAttribute("attendanceList", attendanceList);

                response.sendRedirect("database_success.jsp");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Redirect to an error page or display a message if the list is empty
            response.sendRedirect("error.jsp");
        }
    }
}

