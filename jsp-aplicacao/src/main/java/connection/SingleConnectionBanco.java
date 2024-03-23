package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://localhost:5432/jspdatabase?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "isluc";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}

	static {
		conectar();
	}
	
	public SingleConnectionBanco() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");//carregando os driver do banco
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false); //eles esta falso para fazer alteração no banco sem o nosso comando
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
