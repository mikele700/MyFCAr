package data;

import java.sql.Connection;
import java.sql.SQLException;

import data.ConnectionFactory;
import data.SQLiteConnectionFactory;

public class DBManager {

protected static Connection conn;
	
	final protected static ConnectionFactory CONNECTION_FACTORY = new SQLiteConnectionFactory(); 
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
		        conn = CONNECTION_FACTORY.createConnection();
		    } catch(Exception e) {
		        e.printStackTrace();
	        }
		}
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}
