package tw.com.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener  implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequest requesrt = sre.getServletRequest();
		requesrt.setAttribute("myName", "Ken");
		System.out.println("requestInitialized!!");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed!!");	
	}
}
