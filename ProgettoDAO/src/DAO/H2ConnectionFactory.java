package DAO;

import java.sql.DriverManager;

public class H2ConnectionFactory implements ConnectionFactory {

	//VA CAMBIATO IL PATH
	protected final static String DB_PATH = ".\\azienda.h2"; // Path relativo al progetto
	protected final static String CONNECTION_STRING = "jdbc:h2:" + DB_PATH;
	
	@Override
	public java.sql.Connection createConnection() throws Exception {
		Class.forName("org.h2.Driver");
        return DriverManager.getConnection(CONNECTION_STRING, "sa", "");
	}
}
