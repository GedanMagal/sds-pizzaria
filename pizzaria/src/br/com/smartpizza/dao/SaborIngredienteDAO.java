package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.IngredienteSabor;
import br.com.smartpizza.util.ConexaoUtil;

public class SaborIngredienteDAO {
	public void salvar(IngredienteSabor ing) {
		Connection conn = null;
	
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_INGREDIENTE_SABOR (id_ingredientes, id_sabor) VALUES (?,?)");	
		try {
			conn = ConexaoUtil.getConexao();
			
				PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, ing.getIdIngrediente());
				stmt.setInt(2, ing.getIdSabor());
			
				stmt.execute();
				} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
