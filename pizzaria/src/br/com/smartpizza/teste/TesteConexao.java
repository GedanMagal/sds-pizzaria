package br.com.smartpizza.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.smartpizza.util.ConexaoUtil;

public class TesteConexao {
	public static void main(String[] args) {
		try {
			Connection con = ConexaoUtil.getConexao();
			System.out.println("ok");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}