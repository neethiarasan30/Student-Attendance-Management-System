package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

import DbConnection.DbConnection;


@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter()){
			
			String name = request.getParameter("username");
			
			String password = request.getParameter("password");
			
			String Mobile = request.getParameter("mobileNumber");

			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DbConnection.getConnection();
		      java.sql.Statement smt = con.createStatement();
			
			
			int val = smt.executeUpdate("insert into faculty (username,password,MobileNumber) values ('"+name+"','"+password+"','"+Mobile+"')");
			
			if(val == 1)
			{
				out.print("Faculty details registered Successfully");
			}
			else {
				out.print("Sorry");

			}
		}catch(Exception e) {
			System.out.println(e);		
			}
	}

}
