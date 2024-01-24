package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.Fruit;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	private Map<String,Fruit> fruitNameMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		//�u�|����@�� �b�Ĥ@���B��o��Servlet��
		System.out.println("page1 init!!");
		Fruit appleObj = new Fruit("ī�G","apple",10);
		Fruit bananaObj = new Fruit("����","banana",5);
		Fruit kiwiObj = new Fruit("�_��","kiwi",20);
		fruitNameMap.put("apple", appleObj);
		fruitNameMap.put("banana", bananaObj);
		fruitNameMap.put("kiwi", kiwiObj);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =  resp.getWriter();
		String[] fruits = req.getParameterValues("fruit");
		out.println("<html>");
		out.println("<body>");
		out.println("<ol>");
		for (String f : fruits) {
			Fruit fruitObj = fruitNameMap.getOrDefault(f, null);
			String count = req.getParameter(fruitObj.getKey()+"_count");
		
			out.println("<li>");
			out.println(fruitObj.getName());
			out.println("�ƶq:"+req.getParameter(fruitObj.getKey()+"_count"));
			
			out.println("</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
	}
}
