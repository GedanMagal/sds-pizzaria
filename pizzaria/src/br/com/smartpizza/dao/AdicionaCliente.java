package br.com.smartpizza.dao;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.ConexaoUtil;
import br.com.smartpizza.model.Telefone;

public class AdicionaCliente implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Adicionando cliente");
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String tel = request.getParameter("telefone");
	
		Cliente cliente = new Cliente();
		Telefone telefone = new Telefone();
		telefone.setTelefone(tel);
		
		
		cliente.setNome(sobrenome);
		cliente.setEmail(email);
		cliente.setSobrenome(sobrenome);
		cliente.setTelefone(telefone);
		
		
		System.out.println("Adicionando Cliente" + nome);
		
		Connection connection = ConexaoUtil.getConexao();
		 
		
		
		return null;
	}

}
