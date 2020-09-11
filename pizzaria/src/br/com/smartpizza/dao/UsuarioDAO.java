package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Usuario;
import br.com.smartpizza.util.ConexaoUtil;

public class UsuarioDAO {

	
	public Integer cadastrarUsuario(Usuario usuario) throws Exception {
		Integer id = null;
		Connection conn = null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO TB_USUARIO (US_LOGIN,US_SENHA,GP_USUARIO) VALUES(?,?,?)");
		
		try {
			conn =ConexaoUtil.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getGpUs());
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
	
	public Usuario consultarUsuario(Usuario usuario) throws Exception {
		
		Connection con = null;
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("SELECT * FROM TB_USUARIO WHERE us_login = ? and us_senha = ?");
		
		try {
			
			con = ConexaoUtil.getConexao();
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, usuario.getLogin());

			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("US_ID"));
				usuario.setLogin(rs.getString("us_login"));
				usuario.setGpUs(rs.getString("gp_usuario"));
			}
			return usuario;
			
			
		} catch(SQLException e) {
			throw new Exception();
		}
	}
	
	
}
