package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Usuario;
import br.com.smartpizza.util.ConexaoUtil;

public class UsuarioDAO {

	
	public Integer cadastrarUsuario(Usuario usuario) throws Exception {
		Integer id = null;
		Connection conn = null;
		String grupo ="Cliente";
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO TB_USUARIO (US_LOGIN,US_SENHA,gp_usuario) VALUES(?,?,?)");
		
		try {
			conn =ConexaoUtil.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, grupo);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.first()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			throw new Exception();
		}
	
	}
	
	
}
