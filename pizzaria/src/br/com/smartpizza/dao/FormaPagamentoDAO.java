package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.FormaPagamento;
import br.com.smartpizza.util.ConexaoUtil;

public class FormaPagamentoDAO {

	
	public Integer cadastrarPagamento(FormaPagamento formaPagamento) {
		Connection con = null;
		Integer idPedido = null;
		try {
			
			con = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_FORMA_PAGAMENTO ( DS_TIPO_PAGAMENTO )");
		sql.append(" VALUES(?)");
		PreparedStatement stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, formaPagamento.getTipo());
		
		stmt.execute();
		
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.first()) {
			idPedido = rs.getInt(1);
		}
		
		stmt.close();
		con.close();
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return idPedido;
		
	}
}
