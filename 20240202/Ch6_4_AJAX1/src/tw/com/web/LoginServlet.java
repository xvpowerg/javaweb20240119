package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String acc = req.getParameter("acc");
		String pwd = req.getParameter("pwd");
		PrintWriter out =  resp.getWriter();
		if (acc.equals("qwer") && pwd.equals("123456")) {
			out.println("Success");
		}else {
			out.println("Fail");
		}
		
	}
}
