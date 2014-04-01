package admin;


import java.sql.SQLException;
import java.util.List;
import DB.ResultSetBeanMapping;
import sun.security.jgss.LoginConfigImpl;
import DB.DBManager;

public class AccountDAO {
	public List<Account> find(LoginForm account){
		//SQLï∂çÏê¨
		String sql = "select * from admin where loginId = '" + account.getId() + "' and password = '" + account.getPassword() + "'";
		System.out.println(sql);
		try{

			return DBManager.simpleFind(sql, new AccountMapping());
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}
}
