package DB;


import java.sql.ResultSet;
import java.sql.SQLException;
import DB.ResultSetBeanMapping;

public class RoomMapping implements ResultSetBeanMapping<Room> {
	@Override
	public Room createFormResultSet(ResultSet rs) throws SQLException {
		Room room = new Room();
		room.setCode(rs.getInt("code"));
		room.setName(rs.getString("name"));
		room.setText(rs.getString("text"));
		room.setPeople(rs.getInt("people"));
		room.setPrice(rs.getInt("price"));
		room.setPet(rs.getBoolean("pet"));
		room.setAddress(rs.getString("address"));
		room.setPhoto(rs.getString("photo"));
		room.setStation(rs.getString("station"));
		return room;
	}
}
