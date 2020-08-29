package darts;

import java.sql.*;

public class ConnectorDB {
	
	private Connection con;
	
	public ConnectorDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost/java_db", "java_db", "java123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Connection getCon() {
		return con;
	}
}