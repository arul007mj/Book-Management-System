package Homepage;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getinfo")
public class Insertservlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String b_name=req.getParameter("name");
		String author=req.getParameter("author");
		String yearofpub=req.getParameter("year");
		String publisher=req.getParameter("publisher");
		System.out.println(yearofpub);
		
		PrintWriter out=resp.getWriter();
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "root");
			PreparedStatement ps=c.prepareStatement("insert into book values (?,?,?,?,?)");
			ps.setInt(1,Integer.parseInt(id));
			ps.setString(2, b_name);
			ps.setString(3, author);
			ps.setInt(4, Integer.parseInt(yearofpub));
			ps.setString(5,publisher);
			ps.executeUpdate();
			out.print("<h1>=== DATA SAVED ===</h1>");
			c.close();
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
					
					e.printStackTrace();
				}
			}else {
				out.print("<h1> ====== CONNECTION NOT FOUND ======</h1>");
			}
		}
		
	}


}

	
