package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.ResultSetBeanMapping;

public class UserInfoMapping implements ResultSetBeanMapping<UserInfo> {
	@Override
	public UserInfo createFormResultSet(ResultSet rs) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginid(rs.getString("loginId"));
		userInfo.setMail(rs.getString("mail"));
		userInfo.setAdddate(rs.getDate("adddate"));
		userInfo.setPassword(rs.getString("password"));
		return userInfo;
	}
}
