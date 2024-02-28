package tw.com.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyDbInitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context =  sce.getServletContext();
		String url = context.getInitParameter("db_url");
		String account = context.getInitParameter("db_account");
		String password = context.getInitParameter("db_password");
		String type = context.getInitParameter("db_type");
		DbTools.setUrl(url);
		DbTools.setAccount(account);
		DbTools.setPassword(password);
		DbTools.setType(type);
	}
}
