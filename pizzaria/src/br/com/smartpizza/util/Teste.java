package br.com.smartpizza.util;

import java.sql.Connection;

import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Pessoa;

public class Teste {
	public static void main(String[] args) {

		try {
			Connection con = ConexaoUtil.getConexao();
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	try {
		Connection con = ConexaoUtil.getConexao();
		System.out.println("ok");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		

	}
}
