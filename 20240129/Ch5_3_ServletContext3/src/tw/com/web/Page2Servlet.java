package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out =  resp.getWriter();
		ServletContext context = getServletContext();
		String acc = context.getInitParameter("acc");
		String pwd = context.getInitParameter("pwd");
		out.println("acc:"+acc);
		out.println("pwd:"+pwd);
		//acc
		
		//pwd
	}
}
