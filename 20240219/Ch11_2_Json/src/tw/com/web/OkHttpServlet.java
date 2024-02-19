package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet("/okhttp")
public class OkHttpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String URL = "https://raw.githubusercontent.com/kiang/pharmacies/master/json/points.json";
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request okRequest = new Request.Builder().url(URL).build();
		Call call = client.newCall(okRequest);
		call.enqueue(new Callback() {

			@Override
			public void onFailure(Call arg0, IOException arg1) {
				// TODO Auto-generated method stub
				System.out.println("Ex:"+arg1);
			}

			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				// TODO Auto-generated method stub
				String result = arg1.body().string();
				System.out.println("Result:"+result);
			}
			
		});
		
	}
}
