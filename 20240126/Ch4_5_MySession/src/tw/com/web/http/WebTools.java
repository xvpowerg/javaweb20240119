package tw.com.web.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;
public class WebTools {
   private static final Map <String,MyHttpSession>myhttpSessionMap = new HashMap<>();
   public static final String MY_HTTP_SESSION_ID = "MY_HTTP_SESSION_ID";
   
   public static MyHttpSession getMySession(HttpServletRequest req,
		   HttpServletResponse resp,boolean create) {
	   Cookie[] cookies =   req.getCookies();
	   String mySessionId = "";
	   if (cookies!= null) {
			   Stream<Cookie> str = Stream.of(cookies);
			Optional<Cookie>  opCookie =  str.filter(c->c.getName().
					   equals(MY_HTTP_SESSION_ID)).findFirst();
			if (opCookie.isPresent()) {
				mySessionId = opCookie.get().getValue();
			}
	   }
	   
	   if (mySessionId.isEmpty() && !create) {
		   return null;
	   }
	   
	   MyHttpSession session = null;
	   if (mySessionId.isEmpty() ||
			   myhttpSessionMap.get(mySessionId) == null) {
		   
		   mySessionId =
				 Integer.
				 toHexString(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE)) ;
		   Cookie sessionCookie = new Cookie(MY_HTTP_SESSION_ID,mySessionId);
		   resp.addCookie(sessionCookie);
		   session = new MyHttpSession();
		   myhttpSessionMap.put(mySessionId, session);
	   }else {
		   session =    myhttpSessionMap.get(mySessionId);
	   }
	   
	   
	   return session;
   }
}
