package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Cargo;
import br.com.smartpizza.util.ConexaoUtil;

public class CargoDAO {
	
	public int cadastroCargo(Cargo cargo) throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Integer idCargo = null;

		try {

			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_CARGO (nm_cargo, ds_descricaoCargo) VALUES (?, ?)");

			PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cargo.getNomeCargo());
			stmt.setString(2, cargo.getDescricao());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.first()) {
				idCargo = rs.getInt(1);
			}
			
			return idCargo;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idCargo;
	}

}
