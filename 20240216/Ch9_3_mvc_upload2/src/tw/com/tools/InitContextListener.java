package tw.com.tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class InitContextListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String file_path = context.getInitParameter("file_path");
		ImageTools.setImagePath(file_path);
		// TODO Auto-generated method stub
		System.out.println("contextInitialized:"+file_path);	
	}
}
