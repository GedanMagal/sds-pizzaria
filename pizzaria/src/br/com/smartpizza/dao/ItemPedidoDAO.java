package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.util.ConexaoUtil;

public class ItemPedidoDAO {
	
	public void cadastrarItemPedido(ItemPedido itemPedido) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Integer idItemPedido = null;

			
		
				con = ConexaoUtil.getConexao();
			
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_ITEM_PEDIDO(quantidade, total, id_produto, id_pedido)");
		sql.append(" VALUES(?,?,?,?)");
		PreparedStatement stmt;
	
			stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		
		stmt.setInt(1, itemPedido.getQuantidade());
		stmt.setDouble(2, itemPedido.getTotal());
		stmt.setInt(3, itemPedido.getIdProduto());
		stmt.setLong(4, itemPedido.getIdPedido());
		stmt.execute();
		stmt.close();
		con.close();
			
	}
	
	public void cadastraItemPedidoProduto(List<Produto>produtos ,Integer idItemPedido) {
		Connection con = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO (id_item_pedido, id_produto) VALUES(?,?)");
		try {
			con = ConexaoUtil.getConexao();
			for(Produto prod : produtos) {
			PreparedStatement stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, prod.getIdProduto());
			stmt.setInt(2, idItemPedido);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
