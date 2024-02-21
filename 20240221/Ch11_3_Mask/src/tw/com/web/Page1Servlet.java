package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.json.MaskJsonTools;
import tw.com.net.MaskNetTools;

@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AsyncContext context =   req.startAsync();
		MaskNetTools.downloadMaskJson(json->{
				try {
					MaskJsonTools.maskJsonToObj(json,list->{
					ServletRequest newReq = context.getRequest();
					ServletResponse newResp =context.getResponse();
					newReq.setAttribute("maskList", list);
						try {
							newReq.getRequestDispatcher("/mask.jsp").forward(newReq, newResp);
						}catch(Exception ex) {
							System.out.println("RequestDispatcher Exception:"+ex);
						}
				
						//out.println("list:"+list.size());
						System.out.println("Thread MaskJsonTools:"+Thread.currentThread().getName());
						System.out.println("MaskJsonTools List:"+list.size());
					});
					context.complete();
				}catch(Exception ex) {
					System.out.println("Exception:"+ex);
				}
			}
		);
		
	}
}
