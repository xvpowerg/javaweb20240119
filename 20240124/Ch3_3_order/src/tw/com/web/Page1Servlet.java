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
		//只會執行一次 在第一次運行這個Servlet時
		System.out.println("page1 init!!");
		Fruit appleObj = new Fruit("蘋果","apple",10);
		Fruit bananaObj = new Fruit("香蕉","banana",5);
		Fruit kiwiObj = new Fruit("奇異","kiwi",20);
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
			out.println("數量:"+req.getParameter(fruitObj.getKey()+"_count"));
			
			out.println("</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
	}
}
