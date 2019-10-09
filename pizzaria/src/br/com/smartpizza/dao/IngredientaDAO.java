package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.util.ConexaoUtil;

public class IngredientaDAO {
		
	
	public void cadastarIngredientes(List<Ingrediente> ingredientes,Integer idSabor) {
		Connection conn = null;
		try {
			conn = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_INGREDIENTE_SABOR (id_ingredientes, id_sabor) VALUES (?,?)");	
		
			for(Ingrediente ing: ingredientes) {
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1,ing.getIdIngrediente());
				stmt.setInt(2,idSabor);
				stmt.execute();
			}
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void insereIngredienteSabor(Ingrediente ing) {
		Connection conn = null;
		Integer idIngrediente = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_INGREDIENTE (ds_ingredientes, requerido, valor_ingrediente) VALUES (?,?,?)");	
		try {
			conn = ConexaoUtil.getConexao();
			
				PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, ing.getDsIngrediente());
				stmt.setBoolean(2, ing.isRequerido());
				stmt.setFloat(3, ing.getValorIngrediente());
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.first()) {
					idIngrediente = rs.getInt(1);
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public List<Ingrediente> listIngredienteSabor(int idSabor) {
		List<Ingrediente> ingredientes = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT ING.ID_INGREDIENTES,ING.DS_INGREDIENTES, ING.REQUERIDO, ING.VALOR_INGREDIENTE");
			sql.append(" FROM TB_INGREDIENTE ING");
			sql.append(" 	INNER JOIN TB_INGREDIENTE_SABOR INGSABOR"); 
			sql.append(" 	   ON ING.ID_INGREDIENTES = INGSABOR.ID_INGREDIENTES"); 
			sql.append(" 	INNER JOIN TB_SABOR SAB");
			sql.append(" 	   ON SAB.ID_SABOR = INGSABOR.ID_SABOR");
			sql.append(" WHERE SAB.ID_SABOR = ?");
	
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, idSabor);
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
				Ingrediente ing = new Ingrediente();
				ing.setIdIngrediente(rs.getInt("ID_INGREDIENTES"));
				ing.setDsIngrediente(rs.getString("DS_INGREDIENTES"));
				ing.setRequerido(rs.getBoolean("REQUERIDO"));
				ing.setValorIngrediente(rs.getFloat("VALOR_INGREDIENTE"));
				ingredientes.add(ing);
				}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ingredientes;
	}
	
	public List<Ingrediente> listaIngredientes() {
		List<Ingrediente> ingredientes = new ArrayList<>();
		
		
		try {
			Connection conn = null;
			StringBuilder sql = new StringBuilder();
			conn = ConexaoUtil.getConexao();
			sql.append("SELECT ING.ID_INGREDIENTES,ING.DS_INGREDIENTES, ING.REQUERIDO, ING.VALOR_INGREDIENTE FROM TB_INGREDIENTE ING");
		
	
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) {
				Ingrediente ing = new Ingrediente();
				ing.setIdIngrediente(rs.getInt("ID_INGREDIENTES"));
				ing.setDsIngrediente(rs.getString("DS_INGREDIENTES"));
				ing.setRequerido(rs.getBoolean("REQUERIDO"));
				ing.setValorIngrediente(rs.getFloat("VALOR_INGREDIENTE"));
				ingredientes.add(ing);
				}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ingredientes;
	}
}
