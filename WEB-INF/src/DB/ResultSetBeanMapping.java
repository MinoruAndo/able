package DB;
import java.sql.*;

public interface ResultSetBeanMapping<T> {
	public T createFormResultSet(ResultSet rs) throws SQLException;
}
