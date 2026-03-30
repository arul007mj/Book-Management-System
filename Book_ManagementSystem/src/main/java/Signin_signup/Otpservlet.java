package Signin_signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/otpverification")
public class Otpservlet  extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=res.getWriter();
		String otp=req.getParameter("otp");
		String user_otp=req.getParameter("user_otp");
		
		if (otp.equals(user_otp)) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("Home.html");
			dispatcher.forward(req, res);
		}else {
			out.print("<h1 style='color:red'> ============ INVELID OTP =========</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("otp.html");
			dispatcher.include(req, res);
		}
		
		
	}

}
