package tw.com.web;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
			//HttpServletRequest InputStream
			//HttpServletResponse OutputStream
		   PrintWriter  out =  	response.getWriter();
		   out.println("Page1");
		}
}
