package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	
	private String[] msgs;
	@Override
	public void init(ServletConfig config) throws ServletException {
		msgs = new String[] {"A","V","C"};
		super.init(config);//必須呼叫不然會錯誤
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application =  this.getServletContext();
		application.setAttribute("msgs", msgs);

		
	}
	
}
