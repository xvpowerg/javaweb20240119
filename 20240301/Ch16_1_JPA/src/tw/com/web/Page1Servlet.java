package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
//	@Inject
//	private EntityManager em;
	@EJB
	private MyUserBeanLocal myUserBean;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =   resp.getWriter();	
		out.println("Page1");
		MyUser myuser = new MyUser();
		myuser.setAccount("Ken");
		myuser.setPassword("123456");
		
		boolean b1 = myUserBean.regisrter(myuser);
		MyUser myUser2 =  myUserBean.findUserByAccount("Ken");
		out.println("find!!:"+myUser2);
//		myUserBean.deleteUser(myuser);
//		out.println("Insert:"+b1);
//		out.println("myuser:"+myuser);
	}
}
