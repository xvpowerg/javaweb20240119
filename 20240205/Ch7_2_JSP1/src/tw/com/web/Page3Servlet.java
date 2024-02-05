package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.beans.Item;

@WebServlet("/page3")
public class Page3Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Item i1 = new Item();
		i1.setId(1);
		i1.setName("A1");
		Item i2= new Item();
		i2.setId(2);
		i2.setName("A2");
		Item i3= new Item();
		i3.setId(3);
		i3.setName("A3");
		
		
		ArrayList<Item> itList= new ArrayList<>();
		itList.add(i1);
		itList.add(i2);
		itList.add(i3);
		HttpSession session =  req.getSession();
		session.setAttribute("itemList", itList);
		
		req.getRequestDispatcher("/page3.jsp").forward(req, resp);
	}
}
