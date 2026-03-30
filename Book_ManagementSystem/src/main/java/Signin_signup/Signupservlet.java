package Signin_signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signupservlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection c=null;
		String mail=req.getParameter("email");
		System.out.println("EMAIL :"+mail);
		
		String password=req.getParameter("password");
		 String re_pass=req.getParameter("re-password");
		 System.out.println("PASSWORD :"+password+"RE-PASSWORD :"+re_pass);
		PrintWriter out=resp.getWriter();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db", "root", "root");
			if (password.equals(re_pass)) {
				PreparedStatement ps=c.prepareStatement("insert into  login_table(email,password) values (?,?)");
				ps.setString(1, mail);
				ps.setString(2, re_pass);
				ps.executeUpdate();
				out.print("<h1>"+mail+"AND "+re_pass+" INSERTED INTO DATABASE</h1>");
				resp.sendRedirect("Login.html");
			}else {
				out.print("<h1 style='color:red'>  PASSWORD AND  RE-PASSWORD NOT MATCH</h1>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Signup.html");
				dispatcher.include(req, resp);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			out.print("<h1>"+e+"</h1>");
			e.printStackTrace();
		}
		finally {
			if (c!=null) {
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					out.print("<h1> "+e+"</h1>");
					e.printStackTrace();
				}
			}else {
				out.print("<h1> ====== CONNECTION NOT FOUND ======</h1>");
			}
		}
	}
	
}