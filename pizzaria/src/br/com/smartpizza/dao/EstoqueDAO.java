package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.util.ConexaoUtil;

public class EstoqueDAO {

	public Integer cadastroEstoque(Estoque estoque) {
		Connection conn = null;
		Integer idEstoque = null;
		StringBuilder sql =  new StringBuilder();
		sql.append("INSERT INTO TB_ESTOQUE (qtd_estoque) VALUES(?)");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, estoque.getQtdEstoque());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.first()) {
				idEstoque = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idEstoque;
		}
	public List<Estoque> cadastroEstoque() {
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		Connection conn = null;
		Estoque estoque =null;
		StringBuilder sql =  new StringBuilder();
		sql.append("SELECT * FROM TB_ESTOQUE");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				estoque = new Estoque();
				estoque.setIdEstoque(rs.getInt("id_estoque"));
				estoque.setQtdEstoque(rs.getInt("qtd_estoque"));
				listaEstoque.add(estoque);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaEstoque;
		}
}
