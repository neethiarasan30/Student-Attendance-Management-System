package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try(PrintWriter out = response.getWriter()){
			
			String name = request.getParameter("name");
			
			String rollno = request.getParameter("rollno");
			
			String password = request.getParameter("password");
			
			String mailid = request.getParameter("mailid");

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/SAMS","root","80155");  
			java.sql.Statement stmt=con.createStatement();
			
			
			int val = stmt.executeUpdate("insert into Student (name,rollno,password,email) values ('"+name+"','"+rollno+"','"+password+"','"+mailid+"')");
			
			if(val == 1)
			{
		        response.sendRedirect("AddStudentSuccessPage.jsp");
			}
			else {
				out.print("Sorry");

			}
			}catch(Exception e) {
				System.out.println(e);		
				}
		}

	}
	
