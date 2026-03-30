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

@WebServlet("/getbyid")

public class Retrivesrvlet extends HttpServlet{
	static PrintWriter out;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option=req.getParameter("option");
		String value =req.getParameter("value");
		Connection c=null;
		 out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_db", "root", "root");
			switch (Integer.parseInt(option)) {
			case 1:{
				PreparedStatement ps=c.prepareStatement("select * from book where id=? ");
				ps.setString(1, value);
				ResultSet rs=ps.executeQuery();
				Print(rs);
				break;
			}
			
			case 2:{
				PreparedStatement ps=c.prepareStatement("select * from book where name like ? ");
				ps.setString(1, value+"%%");
				ResultSet rs=ps.executeQuery();
				Print(rs);
				break;
			}
			case 3:{
				PreparedStatement ps=c.prepareStatement("select * from book where author = ? ");
				ps.setString(1, value);
				ResultSet rs=ps.executeQuery();
				Print(rs);
				break;
			}
			case 4:{
				PreparedStatement ps=c.prepareStatement("select * from book order by Year_of_published desc  ");
				ResultSet rs=ps.executeQuery();
				Print(rs);
				break;
			}
		
		}
	} catch (ClassNotFoundException |SQLException e) {
		// TODO Auto-generated catch block
		out.print(e);
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
	
	public static void Print(ResultSet rs2) throws SQLException {
		while (rs2.next()) {
			out.print("<h1> BOOK ID ="+rs2.getInt(1)+"</h1>");
			out.print("<h1> BOOK NAME ="+rs2.getString(2)+"</h1>");
			out.print("<h1> BOOK AUTHOR ="+rs2.getString(3)+"</h1>");
			out.print("<h1> YEAR OF PUBLISHED ="+rs2.getString(4)+"</h1>");
			out.print("<h1> PUBLISHER  ="+rs2.getString(5)+"</h1>");
			out.print("<h1> ----------------------------------------------------------------------------------------------------------</h1>");
			out.print("<hr>");}
		
	}

	}

	

