package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.ResultSetBeanMapping;

public class AdminCreateMapping implements ResultSetBeanMapping<AdminCreate> {
	@Override
	public AdminCreate createFormResultSet(ResultSet rs) throws SQLException {
		AdminCreate adminCreate = new AdminCreate();
		adminCreate.setLoginid(rs.getString("loginId"));
		adminCreate.setStaffNo(rs.getInt("staffId"));
		adminCreate.setAdddate(rs.getDate("adddate"));
		adminCreate.setPassword(rs.getString("password"));
		return adminCreate;
	}
}
