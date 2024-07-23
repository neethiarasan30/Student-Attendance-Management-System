package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DbConnection.DbConnection;


@WebServlet("/StudentValidationServlet")
public class StudentValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
			
			String rollno = request.getParameter("rollno");
			
			String password = request.getParameter("password");
			
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DbConnection.getConnection();
		      java.sql.Statement smt = con.createStatement(); 
			
			ResultSet rs = smt.executeQuery("select * from Student;");
			
			
			boolean temp = false;
			while(rs.next())
			{
				String rollnodb = rs.getString("rollno");
				
				String passdb = rs.getString("password");
				
				if(rollno.equals(rollnodb) && password.equals(passdb))
				{
					temp = true;
					
					HttpSession session=request.getSession();  
				    session.setAttribute("rollno",rollno);
					RequestDispatcher rd	= request.getRequestDispatcher("StudentDetails.jsp");
					rd.forward(request, response);
					break;	
				}
				
			}
			
			if(temp == false)
			{
				out.println("Incorrect UserName or Password");

			}
		}catch(Exception e)
		{
			System.out.println(e);
		}	}

}
