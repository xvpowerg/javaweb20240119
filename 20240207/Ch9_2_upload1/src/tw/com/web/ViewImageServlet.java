package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view_image")
public class ViewImageServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String fileDir = "c:\\upload_images";
			Path filePath = Paths.get(fileDir);
		List<String> fileNameList =	Files.list(filePath).map(p->p.getFileName().toString()).
			collect(Collectors.toList());
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
			for (String fname : fileNameList) {
				out.println("<div>");
				out.println("<img width='30%' height='30%' src='/myimages/"+fname+"'>");
				out.println("</div>");
			}
		
		out.print("</body>");
		out.print("</html>");
		
		}
}
