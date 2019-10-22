package br.com.smartpizza.util;

import java.sql.Connection;

import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Pessoa;

public class Teste {
	public static void main(String[] args) {
<<<<<<< HEAD
		try {
			Connection con = ConexaoUtil.getConexao();
			System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
	try {
		Connection con = ConexaoUtil.getConexao();
		System.out.println("ok");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
>>>>>>> e2c77ebe267f9309433572e46cd441698ab56ee0
		

	}
}
