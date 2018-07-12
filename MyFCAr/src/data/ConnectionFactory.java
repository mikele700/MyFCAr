package data;

public interface ConnectionFactory {

	java.sql.Connection createConnection() throws Exception;
}
