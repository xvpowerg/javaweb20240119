package tw.com.cdi;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tw.com.beans.MyApple;

public class MyProduces {
	@Produces
	@Named("redApple")
	private MyApple getRedApple() {
		MyApple myApple = new MyApple();
		myApple.setName("Red Apple");
		myApple.setPrice(100);
		return myApple;
	}

}
