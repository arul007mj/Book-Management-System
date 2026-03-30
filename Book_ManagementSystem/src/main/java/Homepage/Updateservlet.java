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
@WebServlet("/update")
public class Updateservlet  extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		String colname=req.getParameter("colname");
		String id=req.getParameter("id");
		String new_val =req.getParameter("new_val");
		Connection c=null;
		PrintWriter pw=resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "root");
			switch (Integer.parseInt(colname)) {
			
			case 1:{
				PreparedStatement ps=c.prepareStatement("update book set name=? where id=? ");
				ps.setString(1, new_val);
				ps.setInt(2, Integer.parseInt(id));
				ps.executeUpdate();
				pw.print("<h1>  DATA UPDATED SUCCESSFULLY...... </h1>");
				break;
			}
			case 2:{
				PreparedStatement ps=c.prepareStatement("update book set author=? where id=? ");
				ps.setString(1, new_val);
				ps.setInt(2, Integer.parseInt(id));
				ps.executeUpdate();
				pw.print("<h1>  DATA UPDATED SUCCESSFULLY...... </h1>");
				break;
			}
			case 3:{
				PreparedStatement ps=c.prepareStatement("update book set year_of_published=? where id=? ");
				ps.setString(1, new_val);
				ps.setInt(2, Integer.parseInt(id));
				ps.executeUpdate();
				pw.print("<h1>  DATA UPDATED SUCCESSFULLY...... </h1>");
				break;
			}
			case 4:{
				PreparedStatement ps=c.prepareStatement("update book set publisher=? where id=? ");
				ps.setString(1, new_val);
				ps.setInt(2, Integer.parseInt(id));
				ps.executeUpdate();
				pw.print("<h1>  DATA UPDATED SUCCESSFULLY...... </h1>");
				break;
			}
			
				
			default:
				break;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			pw.print("<h1> "+e+"</h1>");
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
			}
			else {
				pw.print("<h1>CONNECTION NOT FOUND </h1>");
			}
		}
	}

}

