package br.com.smartpizza.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.dto.PessoaDTO;
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
	
	public List<PessoaDTO> listaPessoas(){
		List<PessoaDTO> listPessoas = new ArrayList<PessoaDTO>();
		Connection conn = null;
				
			try {
				conn = ConexaoUtil.getConexao();
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT CLI.NM_CLIENTE,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,en.ds_bairro"); 
				sql.append(" FROM PIZZA_PROJETO.TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
				PreparedStatement stmt = conn.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
				PessoaDTO p = new PessoaDTO();
				p.setNome(rs.getString("NM_CLIENTE"));
				p.setSobrenome(rs.getString("SOBRENOME"));
				p.setEmail(rs.getString("DS_EMAIL"));
				p.setTelefone(rs.getString("CLI_TELEFONE"));
				p.setCelular(rs.getString("CLI_CELULAR"));
				p.setEndereco(rs.getString("DS_LOGRADOURO"));
				p.setNumero(rs.getString("NM_ENDERECO"));
				p.setCep(rs.getString("NM_CEP"));
				p.setBairro(rs.getString("DS_BAIRRO"));
				listPessoas.add(p);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listPessoas;
	}
}
