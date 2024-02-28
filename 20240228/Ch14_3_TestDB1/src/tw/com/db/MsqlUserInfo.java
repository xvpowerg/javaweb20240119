package tw.com.db;


public class MsqlUserInfo implements UserInfoDao{

	@Override
	public boolean regisrter(String account, 
			String password) {
		// TODO Auto-generated method stub
		System.out.println("MsqlUserInfo regisrter");
		return true;
	}



}
