package BLL;

import java.util.Date;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAL.DAL;

public class BLL 
{
	public void excuteDB(String q1, String q2, String q3, String q4, String q5, String q6) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3456/vlance?autoReconnect=true&useSSL=false", "root", "");
	        Statement statement = connection.createStatement();
	        String query = "INSERT INTO jobs (Title, Name, NameJob, Salary, Address, Content) VALUES ('" + q1 + "', '" + q2 + "', '" + q3 + "', '" + q4 + "', '" + q5 + "', '" + q6 + "')";
	        statement.executeUpdate(query);

	        statement.close();
	        connection.close();
		}
		catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	public BLL() {
		super();
	}
}
