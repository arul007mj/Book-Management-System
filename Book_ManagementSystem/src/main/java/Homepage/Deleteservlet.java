package Homepage;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Deleteservlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c=null;
		PrintWriter out=res.getWriter();
		String id=req.getParameter("id");
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "root");
		
		PreparedStatement ps=c.prepareStatement("delete from book where id=?");
		ps.setInt(1, Integer.parseInt(id));
		ps.executeUpdate();
		out.print("<h1>DATA DELETED SUCCESSFULLY .....!!!</h1>");
	} catch (ClassNotFoundException |SQLException e) {
		// TODO Auto-generated catch block
		out.print("<h1> "+e+"</h1>");
		e.printStackTrace();
	}
	
	finally {
		if (c !=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.print("<h1>"+e+"</h1>");
				e.printStackTrace();
			}
		}
		else {
			out.print("<h1> CONNECTION NOT THERE </h1>");
		}
	}

	}

}


