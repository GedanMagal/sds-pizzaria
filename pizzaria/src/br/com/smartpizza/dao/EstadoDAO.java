package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.model.Estado;
import br.com.smartpizza.util.ConexaoUtil;

public class EstadoDAO {

	public List<Estado> listarEstados(){
		List<Estado> listEstados = new  ArrayList<Estado>();
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TB_ESTADO");
		try {
			conn = ConexaoUtil.getConexao();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Estado estado = new Estado();
				estado.setIdEstado(rs.getInt(1));
				estado.setDsuf(rs.getString(2));
				estado.setDsSigla(rs.getString(3));
				listEstados.add(estado);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listEstados;
	}
}
