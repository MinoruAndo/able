package admin;


import java.sql.ResultSet;
import java.sql.SQLException;
import DB.ResultSetBeanMapping;

public class AccountMapping implements ResultSetBeanMapping<Account> {
	@Override
	public Account createFormResultSet(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getString("loginId"));
		account.setPassword(rs.getString("password"));
		return account;
	}
}
