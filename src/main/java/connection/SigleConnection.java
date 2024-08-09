package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SigleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/jspdb?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "isluc";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	public SigleConnection() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
				 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
