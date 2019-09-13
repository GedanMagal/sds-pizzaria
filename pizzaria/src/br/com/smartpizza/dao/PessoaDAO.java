package br.com.smartpizza.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Pessoa;
import br.com.smartpizza.util.ConexaoUtil;

public class PessoaDAO {
	private UsuarioDAO	us = new UsuarioDAO();
	private EnderecoDAO	enderecoDAO = new EnderecoDAO();
	
	public PessoaDAO() {
		
	}
	public void cadastroPessoaClient(Cliente p) throws ClassNotFoundException, SQLException {
		
		
		Connection  conn = null;
		Integer idPessoa = null;
		
		try {
		
			conn = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		Integer us_id = us.cadastrarUsuario(p.getUsuario());
		sql.append("INSERT INTO TB_CLIENTE (nm_cliente, nm_cpf,sobrenome,ds_email,senha,cli_telefone,cli_celular,us_id)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?)");
		
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getSobrenome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getSenha());
			stmt.setString(6, p.getTelefone());
			stmt.setString(7, p.getCelular());
			stmt.setInt(8, us_id);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.first()) {
				idPessoa = rs.getInt(1);
			}
			enderecoDAO.cadastrarEndereco(p.getEndereco(),idPessoa);
		
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
