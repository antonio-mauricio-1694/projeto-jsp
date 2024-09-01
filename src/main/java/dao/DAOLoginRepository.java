package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SigleConnection;
import model.ModelLogin;

public class DAOLoginRepository {
	
	
	private Connection connection;
	
	public DAOLoginRepository() {
		connection = SigleConnection.getConnection();
	}
	
	public boolean validarAutenticar(ModelLogin modelLogin) throws SQLException {
		
	String sql = " select * from model_login where upper(login) = upper(?) and upper(password) = upper(?)";
	
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.setString(1, modelLogin.getLogin());
	statement.setString(2, modelLogin.getPassword());
	
	
	
	
	
	ResultSet resultSet = statement.executeQuery();
	
	if(resultSet.next()) {
		return true;
	}
	
	return false;
		
	}

}
