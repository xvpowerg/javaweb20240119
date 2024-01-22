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
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sn = req.getParameter("sn");
		String type = req.getParameter("type");
		PrintWriter out =   resp.getWriter();
		if (sn == null) {
			out.println("SN Empty");
		}else {
			out.println(sn);
		}
		out.println(type);
	}
}
