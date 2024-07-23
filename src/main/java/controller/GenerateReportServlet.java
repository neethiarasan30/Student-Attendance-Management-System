package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/GenerateReportServlet")
public class GenerateReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportDate = request.getParameter("reportDate");
        
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=attendance_report_" + reportDate + ".pdf");
        
        Document document = new Document();
        try {
            OutputStream out = response.getOutputStream();
            PdfWriter.getInstance(document, out);
            document.open();
            
            // Add the title to the PDF
            document.add(new Paragraph("Attendance Report for " + reportDate));
            
            // Fetch attendance data for the given date from the database
            String url = "jdbc:mysql://localhost:3306/SAMS";
            String username = "root";
            String password = "80155";
            
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT name, attendance FROM attendance WHERE date = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, reportDate);
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String studentName = rs.getString("name");
                            String status = rs.getString("attendance");
                            document.add(new Paragraph("Name: " + studentName + " - Attendance Status: " + status));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                document.add(new Paragraph("Error fetching data from database: " + e.getMessage()));
            }
            
            document.close();
            out.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
