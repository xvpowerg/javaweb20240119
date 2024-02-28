package tw.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.beans.UserInfo;

public interface UserInfoDao {
	
	default boolean regisrter(String account, String password) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user_info(account,password) VALUES(?,?)";	
		try(Connection conn = DbTools.getConnection();
			PreparedStatement pstem = conn.prepareStatement(sql);){
			pstem.setString(1, account);
			pstem.setString(2, password);
			int count = pstem.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
	}


	default UserInfo findUserInfoByAccount(String account) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user_info WHERE account = ?";
		try(Connection conn =  DbTools.getConnection();
			PreparedStatement pstem = conn.prepareStatement(sql)){
			pstem.setString(1, account);
			ResultSet result =   pstem.executeQuery();
			if (result.next()) {
				int id = result.getInt(1);
				String accountStr = result.getString(2);
				String passwordStr = result.getString(3);
				UserInfo userInfo = new UserInfo();
				userInfo.setId(id);
				userInfo.setAccount(accountStr);
				userInfo.setPassword(passwordStr);
				return userInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return null;
	}
}
