package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.util.ConexaoUtil;

public class IngredientaDAO {
		
	
	
	public Integer findMaxId() {
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		Integer idIngrediente = null;
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("SELECT MAX(id_ingredientes) FROM TB_INGREDIENTE");
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				idIngrediente = rs.getInt(1);
			}
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idIngrediente;
	}
	
	public void insereIngredienteSabor(Ingrediente ing) {
		Connection conn = null;
	
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_INGREDIENTE (ds_ingredientes, requerido, valor_ingrediente) VALUES (?,?,?)");	
		try {
			conn = ConexaoUtil.getConexao();
			
				PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, ing.getDsIngrediente());
				stmt.setBoolean(2, ing.isRequerido());
				stmt.setFloat(3, ing.getValorIngrediente());
				stmt.execute();
			
				
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
