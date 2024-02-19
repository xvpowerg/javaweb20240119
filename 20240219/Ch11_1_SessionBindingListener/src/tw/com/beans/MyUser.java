package tw.com.beans;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.time.LocalDateTime;
public class MyUser  implements HttpSessionBindingListener{
	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyUser [account=" + account + ", password=" + password + "]";
	}
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		LocalDateTime time = LocalDateTime.now();
		System.out.println("login:"+time);
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		LocalDateTime time = LocalDateTime.now();
		System.out.println("logout:"+time);
		
	}
	
}
