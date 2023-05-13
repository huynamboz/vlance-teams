package DAL;
import java.sql.*;
public class DBHelper {
	private Connection _cnn;
	private DBHelper(String s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			_cnn = DriverManager.getConnection(s,"root","");
		} catch (Exception e) {
			System.out.print("Error init connection :" + e);
		}
	}
	public static DBHelper _Instance;
	public static DBHelper Instance() {
		if (_Instance == null) {
			_Instance = new DBHelper("jdbc:mysql://localhost:3306/vlance?autoReconnect=true&useSSL=false");
		}
		return _Instance;
	}
	public ResultSet execute(String query, String[] parameters) throws SQLException {
		System.out.println(parameters.length);
		PreparedStatement pstmt = _cnn.prepareStatement(query);
		for(int i = 0 ; i < parameters.length; i++) {
			System.out.println(parameters[i]);
			pstmt.setString(i+1, parameters[i]);
		}
		return pstmt.executeQuery();
	}
}
