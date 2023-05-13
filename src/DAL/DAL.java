package DAL;

import java.sql.*;
public class DAL {
	public Boolean login(String email, String password) throws SQLException {
		String[] params = { email };
		ResultSet rs  = DBHelper.Instance().execute("select * from users where users.email = ?", params);
		System.out.println(123);
		if (!rs.next()) {
		    // No user with the given email address was found
		    return false;
		}
		String passwordFromResultSet = rs.getString("password");

		System.out.println(passwordFromResultSet);

        // Check if the password matches the given password
        return passwordFromResultSet.equals(password);
	}
}
