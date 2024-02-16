package tw.com.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;
@WebListener
public class MySessionAttrListener implements HttpSessionAttributeListener {
		@Override
		public void attributeAdded(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			String name = event.getName();
			String value = event.getValue().toString();
			System.out.println("Add:"+name+":"+value);
			if (name.equals("login")) {
				LocalDateTime loingTime = LocalDateTime.now();
				System.out.println("loingTime:"+loingTime);
			}
			
		}
		
		@Override
		public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			String name = event.getName();
			String value = event.getValue().toString();
			String newValue = event.getSession().getAttribute(name).toString();
			System.out.println("Replaced:"+name+":"+value+":"+newValue);
			
		}
		@Override
		public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			String name = event.getName();
			String value = event.getValue().toString();
			System.out.println("attributeRemoved:"+name+":"+value);
			
			if (name.equals("login")) {
				LocalDateTime logoutTime =  LocalDateTime.now();
				System.out.println("logoutTime:"+logoutTime);
			}
		
		}
}
