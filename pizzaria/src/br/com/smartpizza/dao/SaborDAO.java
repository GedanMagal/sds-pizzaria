package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.util.ConexaoUtil;

public class SaborDAO {
		private IngredientaDAO Idao  = new IngredientaDAO();
	public Integer cadastrarSabores(Sabor sabor) {
		Connection conn = null;
		Integer idSabor = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_SABOR (ds_sabor) VALUES (?)");	
		try {
			conn = ConexaoUtil.getConexao();
			
				PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, sabor.getDsSabor());
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.first()) {
					idSabor = rs.getInt(1);
				}
				
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idSabor;
	}
	public Integer findMaxId() {
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		Integer idSabor = null;
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("SELECT MAX(id_sabor) FROM TB_SABOR");
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				idSabor = rs.getInt(1);
			}
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idSabor;
	}
}
