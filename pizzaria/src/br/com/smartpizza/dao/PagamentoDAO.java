package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Pagamento;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.util.ConexaoUtil;

public class PagamentoDAO {

	
	public Integer cadastrarPagamento(Pagamento pagamento) {
		Connection con = null;
		Integer idPedido = null;
		try {
			
			con = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_PAGAMENTO (DS_TIPO_PAGAMENTO, VALOR_PAGAMENTO, TROCO)");
		sql.append(" VALUES(?,?,?)");
		PreparedStatement stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, pagamento.getDsPagamento());
		stmt.setDouble(2, pagamento.getVlPagamento());
		stmt.setDouble(3, pagamento.getTroco());
		
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
