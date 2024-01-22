package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		PrintWriter out =  resp.getWriter();
		out.println("<html>");
			out.println("<body>");
				out.println("<ul>");
					
						for(int i =0; i < 10;i++) {
							out.println("<li>");
							out.println( (char)(i+'A'));
							out.println("</li>");
						}
					
				out.println("</ul>");
			out.println("</body>");
		out.println("</html>");
	}
}
