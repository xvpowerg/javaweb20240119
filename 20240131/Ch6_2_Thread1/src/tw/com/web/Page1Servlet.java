package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private ExecutorService es;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		es = Executors.newCachedThreadPool();
	}
	private void test(HttpServletResponse resp) {
		
		for (int i=1; i<=5000000;i++) {
			System.out.println(i);
		}
		LocalDateTime time = LocalDateTime.now();
		try {
			resp.getWriter().println("test Finish..:"+time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test:"+Thread.currentThread()+
				":"+time);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = 	 resp.getWriter();
		out.println("Page1 Start:"+Thread.currentThread().getName());
		
		es.execute(()->{
			
			test(resp);
			
		});
		
		out.println("Page1 End:"+Thread.currentThread().getName());
	}
}
