package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/page3")
public class Page3Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		 HttpSession session =  req.getSession();
		 int count = (Integer)session.getAttribute("count");
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='index.html'>Home</a>");
		out.println("<H2>Page3</H2>");
		out.println("<H2>Count:"+count+"</H2>");
		out.println("</body>");
		out.println("</html>");
	}
}
