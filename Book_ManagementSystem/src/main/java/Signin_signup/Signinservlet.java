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
@WebServlet("/Login")
public class Signinservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub

		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		PrintWriter out=resp.getWriter();
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db", "root", "root");
			PreparedStatement ps=c.prepareStatement("select email,password from login_table where email=? and password=?");
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
		
			if (rs.next()) {
					RequestDispatcher dispatcher=req.getRequestDispatcher("otp.html");
					dispatcher.forward(req, resp);	
				
			}else {
				out.print("<h1 style='color:red'> INVALID PASSWORD OR EMAIL AND PASSWORD NOT MATCH</h1>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
				dispatcher.include(req, resp);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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


