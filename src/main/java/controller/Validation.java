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

import com.mysql.cj.xdevapi.Statement;

import DbConnection.DbConnection;


@WebServlet("/Validation")
public class Validation extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
			
			String name = request.getParameter("username");
			
			String password = request.getParameter("password");
			
			

			
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DbConnection.getConnection();
		      java.sql.Statement smt = con.createStatement(); 
			
			ResultSet rs = smt.executeQuery("select * from faculty;");
			
			
			boolean temp = false;
			
			if(name.equals("admin") && password.equals("admin"))
			{
				temp = true;
				RequestDispatcher rd	= request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
			}
			else {
			
			while(rs.next())
			{
				String username = rs.getString("username");
				
				String pass = rs.getString("password");
				
				 if(name.equals(username) && password.equals(pass))
				{
					out.println("welcome Faculty " + name);
					temp = true;
					
					
					RequestDispatcher rd	= request.getRequestDispatcher("Faculty.jsp");
					rd.forward(request, response);
					break;
					
				}				
				
			}
			}
			if(temp == false)
			{
				out.println("Incorrect UserName or Password");

			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
