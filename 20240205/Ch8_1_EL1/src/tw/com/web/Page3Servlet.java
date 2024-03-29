package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page3")
public class Page3Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String canShow = req.getParameter("canShow");
		req.setAttribute("canShow", Boolean.parseBoolean(canShow) );
		req.getRequestDispatcher("/page3.jsp").forward(req, resp);
	}
}
