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
	
	public void cadastrarItemPedido(ItemPedido itemPedido) {
		Connection con = null;
		try {
			Integer idItemPedido =null;
			con = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_ITEM_PEDIDO(quantidade, desconto, total)");
		sql.append(" VALUES(?,?,?)");
		PreparedStatement stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, itemPedido.getQuantidade());
		stmt.setBigDecimal(2, itemPedido.getDesconto());
		stmt.setBigDecimal(3, itemPedido.getTotal());
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.first()) {
			idItemPedido = rs.getInt(1);
		}
		cadastraItemPedidoProduto(itemPedido.getProdutos(),idItemPedido);
		
		stmt.close();
		con.close();
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
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
