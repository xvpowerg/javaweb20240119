package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		 String item =  req.getParameter("item");
		 PrintWriter out = resp.getWriter();
		 out.println("item:"+item);
		 
		 String[] items = req.getParameterValues("item");
		 for (String it : items) {
			 out.println(it);
		 }
		 
		 Map<String,String[]> valueMap = 
				 req.getParameterMap();
		 valueMap.forEach((k,v)->{
			 out.println(k+":");
			 Stream<String> s = Stream.of(v);
			 String values = 
					 s.collect(Collectors.joining(","));
			 out.println(values);
		 });
		 
	}
	
}
