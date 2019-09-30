package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.util.ConexaoUtil;

public class SaborDAO {
		
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
	
	public List<Sabor> listaSAbores(){
		 IngredientaDAO Idao  = new IngredientaDAO();
		List<Sabor> listaSabor = new ArrayList<Sabor>();
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("SELECT id_sabor, ds_sabor FROM TB_SABOR");
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Sabor sabor = new Sabor();
				sabor.setIdSabor(rs.getInt("id_sabor"));
				sabor.setDsSabor(rs.getString("ds_sabor"));
				sabor.setIngredientes(Idao.listIngrediente(sabor.getIdSabor()));
				listaSabor.add(sabor);
			}
			
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaSabor;
		}
}
