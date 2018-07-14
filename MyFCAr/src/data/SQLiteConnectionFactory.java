package data;

import java.sql.DriverManager;

public class SQLiteConnectionFactory implements ConnectionFactory {

	protected final static String DB_PATH = "..\\fca.db"; //Terminale
	//protected final static String DB_PATH = ".\\fca.db"; //Eclipse
	protected final static String CONNECTION_STRING = "jdbc:sqlite:" + DB_PATH;
	
	@Override
	public java.sql.Connection createConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection(CONNECTION_STRING);
	}
}
