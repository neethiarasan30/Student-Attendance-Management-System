package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentAttendance;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<StudentAttendance> attendanceList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String attendanceDate = request.getParameter("attendanceDate");

        Enumeration<String> parameterNames = request.getParameterNames();
        
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            
            if (paramName.startsWith("attendance_")) {
                String rollno = paramName.substring(11); // Get roll number from parameter name
                String[] attendanceStatuses = request.getParameterValues(paramName);

                // Determine the attendance status
                String attendanceStatus = "";
                if (attendanceStatuses != null) {
                    for (String status : attendanceStatuses) {
                        if (status.equals("Present")) {
                            attendanceStatus = "Present";
                        } else if (status.equals("Absent")) {
                            attendanceStatus = "Absent";
                        }
                    }
                }
                
                String name = request.getParameter("name_" + rollno);
                
                // Create a new StudentAttendance object and add it to the list
                StudentAttendance studentAttendance = new StudentAttendance(name, rollno, attendanceStatus, attendanceDate);
                attendanceList.add(studentAttendance);
            }
        }

        // Store the attendance list in the session or application context
        request.getSession().setAttribute("attendanceList", attendanceList);

        // Redirect to a success page or back to the form
        response.sendRedirect("success.jsp");
    }
}
