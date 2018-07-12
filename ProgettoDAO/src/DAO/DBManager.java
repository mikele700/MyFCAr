package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

protected static Connection conn;
	
	/*
	 * Si è scelto di istanziare il DBManager con il DBMS H2. Cambiando la classe
	 * ConnectionFactory era possibile usare DBMS differenti, come ad esempio MS Access.
	 * 
	 * 	connectionFactory = new MSAccessConnectionFactory();
	 */
	final protected static ConnectionFactory CONNECTION_FACTORY = new H2ConnectionFactory(); 
	
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
