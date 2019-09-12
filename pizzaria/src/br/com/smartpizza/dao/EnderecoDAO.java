package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.smartpizza.model.Endereco;
import br.com.smartpizza.util.ConexaoUtil;

public class EnderecoDAO {

	public void cadastrarEndereco(List<Endereco>enderecos,Integer idPessoa) {
		
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO TB_ENDERECO (ds_logradouro, nm_endereco, nm_cep, ds_bairro, id_cidade, id_cliente)");
		sql.append(" values (?,?,?,?,?,?,?)");
		try {
			conn = ConexaoUtil.getConexao();
			for(Endereco endereco : enderecos) {
				PreparedStatement stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1,endereco.getDsLogradouro());
				stmt.setString(2,endereco.getNumEndereco());
				stmt.setString(3,endereco.getCep());
				stmt.setString(4,endereco.getBairro());
				stmt.setInt(5,endereco.getCidade().getIdCidade());
				stmt.setInt(5,idPessoa);
			}
		
			
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
