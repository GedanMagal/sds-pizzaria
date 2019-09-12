package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.smartpizza.model.Telefone;
import br.com.smartpizza.util.ConexaoUtil;

public class TelefoneDAO {
	
	public void cadastrarTelefone(List<Telefone> telefones, int idPessoa) {
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_TELEFONE (DS_TELEFONE, TEl_CLASSIFICADOR,ID_CLIENTE)");
		sql.append("VALUES(?,?,?)");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			for(Telefone telefone: telefones) {
				stmt.setString(1, telefone.getTelefone());
				stmt.setString(2, telefone.getClassificador());
				stmt.setInt(3, idPessoa);
				stmt.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
