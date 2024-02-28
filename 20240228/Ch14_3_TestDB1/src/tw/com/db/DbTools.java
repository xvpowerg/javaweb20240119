package tw.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTools {
	private static String url;
	private static String account;
	private static String password;
	private static String type;
	
	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		DbTools.type = type;
	}

	private DbTools() {}
	
	public static Connection getConnection() 
			throws SQLException{
		Connection conn = 
				DriverManager.getConnection(url,account,password);
		return conn;
	}
	
	public static String getUrl() {
		return url;
	}
	 static void setUrl(String url) {
		DbTools.url = url;
	}
	public static String getAccount() {
		return account;
	}
	 static void setAccount(String account) {
		DbTools.account = account;
	}
	public static String getPassword() {
		return password;
	}
	 static void setPassword(String password) {
		DbTools.password = password;
	}
	 
	 public static UserInfoDao newUserInfoDao() {
		 System.out.println("type:"+type);
		 switch(type) {
		 case "mysql":
			 return new MySqlUserInfo();
		 case "mssql":
			 return new MsqlUserInfo();
		 }
		 return new MySqlUserInfo();
	 }
	
}
