package br.com.smartpizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

	public static Connection getConexao() throws ClassNotFoundException {
		Connection con = null;

	
		return con;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			Connection connection = getConexao();
			connection.close();
			System.out.println("Conexão aberta com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
