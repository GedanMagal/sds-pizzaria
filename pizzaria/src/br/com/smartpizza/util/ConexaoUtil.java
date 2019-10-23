package br.com.smartpizza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

	public static Connection getConexao() throws ClassNotFoundException {
		Connection con = null;
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://pizza-projeto.mysql.uhserver.com:3306/pizza_projeto?useSSL=false", "pizza_user", "J1ck50nb@");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Conexão invalida");
		}
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
