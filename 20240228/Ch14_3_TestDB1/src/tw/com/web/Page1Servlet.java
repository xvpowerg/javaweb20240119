package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.UserInfo;
import tw.com.db.DbTools;
import tw.com.db.MySqlUserInfo;
import tw.com.db.UserInfoDao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
//		String account = this.getServletContext().getInitParameter("db_account");
//		String password =  this.getServletContext().getInitParameter("db_password");
//		String dbUrl = this.getServletContext().getInitParameter("db_url");
//		
//		try(Connection conn = DriverManager.getConnection(dbUrl,account,password)){
//			
//		}catch(SQLException ex) {
//			System.out.println(ex);
//		}
		
//		try(Connection conn =  DbTools.getConnection()){
//			
//		}catch(SQLException ex) {
//			System.out.println(ex);
//		}
		
//		UserInfoDao userInfoDao = new MySqlUserInfo();
//		boolean b1 = userInfoDao.regisrter("ken", "12345");
//		System.out.println(b1);
		
//		UserInfoDao userInfoDao ;
//		UserInfo userInfo =   userInfoDao.findUserInfoByAccount("ken");
//		System.out.println(userInfo);
		
		 UserInfoDao   userInfoDao = DbTools.newUserInfoDao();
		// UserInfo userInfo =  userInfoDao.findUserInfoByAccount("ken");
		 //System.out.println(userInfo);
		 userInfoDao.regisrter("vivin", "12345");
	}
	
}
