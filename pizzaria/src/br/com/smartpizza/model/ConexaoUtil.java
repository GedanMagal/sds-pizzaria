package br.com.smartpizza.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

	public static Connection getConexao() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza_projeto?useSSL=false", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Conexão invalida");
		}
		return con;
	}
	
	public static void main(String[] args) {
		
		try {
			Connection connection = getConexao();
			connection.close();
			System.out.println("Conexão aberta com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
