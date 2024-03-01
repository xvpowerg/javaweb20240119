package tw.com.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tw.com.jpa.MyUser;

@Stateless
public class MyUserBean  implements MyUserBeanLocal{
	@Inject
	private EntityManager em;
	
	@Override
	public boolean login(MyUser myUser) {
		// TODO Auto-generated method stub
		MyUser myUserObj = findUserByAccount(myUser.getAccount());
			if (myUserObj == null) {
				return false;
			}
		return myUserObj.getPassword().equals(myUser.getPassword());
	}

	@Override
	public boolean regisrter(MyUser myUser) {
		// TODO Auto-generated method stub
		try {
			em.persist(myUser);
			return true;
		}catch(Exception ex) {
			System.out.println("regisrter:"+ex);
		}
		
		return false;
	}

	@Override
	public MyUser findUserByAccount(String account) {
		// TODO Auto-generated method stub
		MyUser myUser = null;
		TypedQuery<MyUser> query =  em.createNamedQuery("findMyUser",MyUser.class);
		query.setParameter("account", account);
		try {
			 myUser =  query.getSingleResult();
			 return myUser;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	@Override
	public boolean deleteUser(MyUser myUser) {
		// TODO Auto-generated method stub
		
		try {
			//跟MyUser資料表 做關聯
			myUser =  em.merge(myUser);
			em.remove(myUser);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	
		return false;
	}

}
