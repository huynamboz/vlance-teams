package DAL;
import java.sql.*;

import javax.swing.table.DefaultTableModel;
public class DBHelper {
	Statement stmt;
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
	public void executeUpdate(String query, String[] parameters) throws SQLException {
		System.out.println(parameters.length);
		PreparedStatement pstmt = _cnn.prepareStatement(query);
		for(int i = 0 ; i < parameters.length; i++) {
			System.out.println(parameters[i]);
			pstmt.setString(i+1, parameters[i]);
		}
		pstmt.executeUpdate();
	}
	public String[][] getDataRows() {
		try {
			PreparedStatement pstmt = _cnn.prepareStatement("select * from jobs");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rmd = rs.getMetaData();
			int socot = rmd.getColumnCount();
			String[] colName = new String[socot];
			for (int i = 1; i<= socot;i++ ) {
				System.out.print(rmd.getColumnLabel(i));
				colName[i-1] = rmd.getColumnLabel(i);
			}
			
			rs.last(); //move to last record
			int rowCount = rs.getRow();
			rs.beforeFirst(); // move to first
			String [][] data = new String [rowCount][socot];
			int rowIndex = 0 ;
			while(rs.next()) {
				for ( int i =1 ; i<= socot; i++ ) {
					data[rowIndex][i-1] = rs.getString(i);
				}
				rowIndex++;
			}
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("get row err - "+e);
			String[][] a = new String [1][1];;
			return a;
		}
	}
	public String[] getDataCols() {
		try {
			
			//ResultSet rs = this.stmt.executeQuery("select * from jobs");
			PreparedStatement pstmt = _cnn.prepareStatement("select * from jobs");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rmd = rs.getMetaData();
			int socot = rmd.getColumnCount();
			String[] colName = new String[socot];
			for (int i = 1; i<= socot;i++ ) {
				System.out.print(rmd.getColumnLabel(i));
				colName[i-1] = rmd.getColumnLabel(i);
			}
			return colName;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("getcol err - "+e);
			return new String[1];
		}
		
	}
}
