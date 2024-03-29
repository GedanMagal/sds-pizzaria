package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.smartpizza.model.Pagamento;
import br.com.smartpizza.util.ConexaoUtil;

public class PagamentoDAO {

	
	public Integer cadastrarPagamento(Pagamento pagamento,Integer idFormaPagamento) {
		Connection con = null;
		Integer idPedido = null;
		try {
			
			con = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_PAGAMENTO (DT_HORAPAGGAMENTO, ID_FORMA_PAGAMENTO)");
		sql.append(" VALUES(?,?)");
		PreparedStatement stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		stmt.setDate(1, new Date(pagamento.getDataHoraPagamento().getTime()));
		stmt.setInt(2, idFormaPagamento);
		
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
