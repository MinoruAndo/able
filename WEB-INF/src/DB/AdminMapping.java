package DB;


import java.sql.ResultSet;
import java.sql.SQLException;
import DB.ResultSetBeanMapping;

public class AdminMapping implements ResultSetBeanMapping<Admin> {
	@Override
	public Admin createFormResultSet(ResultSet rs) throws SQLException {
		Admin account = new Admin();
		account.setId(rs.getString("loginId"));
		account.setPassword(rs.getString("password"));
		return account;
	}
}
