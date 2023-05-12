package DAL;
import java.sql.*;
import java.sql.PreparedStatement;
public class DBHelper {
	private Connection _cnn;
	private DBHelper(String s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			_cnn = DriverManager.getConnection(s,"root","Huynam@2003");
		} catch (Exception e) {
			System.out.print("Error init connection :" + e);
		}
	}
	public static DBHelper _Instance;
	public static DBHelper Instance() {
		if (_Instance == null) {
			_Instance = new DBHelper("jdbc:mysql://localhost:3306/java?autoReconnect=true&useSSL=false");
		}
		return _Instance;
	}
	public void ExecuteUpdate(String[] parameters, String query) {
		try {
			PreparedStatement pstmt = _cnn.prepareStatement(query);
			for(int i = 0 ; i < parameters.length; i++) {
				pstmt.setString(i+1, parameters[i]);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.print("Err execute sql :" + e);
		}
		
	}
}
