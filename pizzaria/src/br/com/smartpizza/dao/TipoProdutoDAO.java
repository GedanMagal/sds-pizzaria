package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.model.TipoProduto;
import br.com.smartpizza.util.ConexaoUtil;

public class TipoProdutoDAO {
	
	public List<TipoProduto> listaTipos(){
		List<TipoProduto> tipos = new ArrayList<TipoProduto>();
		StringBuilder sql = new StringBuilder();
		TipoProduto tipo = null;
		Connection conn = null;
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("SELECT * FROM tb_tipo_produto");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs  = stmt.executeQuery();
			while(rs.next()) {
				 tipo = new TipoProduto();
				 tipo.setIdTipoProduto(rs.getInt("id_TIPO_PRODUTO"));
				tipo.setDsTipoProduto(rs.getString("ds_tipo_produto"));
				tipos.add(tipo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return tipos;
	}
}
