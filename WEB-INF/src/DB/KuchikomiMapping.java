package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KuchikomiMapping implements ResultSetBeanMapping<Kuchikomi> {
	@Override
	public Kuchikomi createFormResultSet(ResultSet rs) throws SQLException {
		Kuchikomi kuchikomi = new Kuchikomi();
		kuchikomi.setStation(rs.getString("station"));
		kuchikomi.setKuchikomi(rs.getString("kuchikomi"));
		kuchikomi.setLoginid(rs.getString("loginid"));
		kuchikomi.setAddNo(rs.getInt("addNo"));
		return kuchikomi;
	}
}
