package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.dto.PedidoDTO;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.util.ConexaoUtil;


public class PedidoDAO {
	
	public Integer cadastrarPedido(Pedido pedido, Integer idPagamento) {
		Connection con = null;
		Integer idPedido = null;
		try {
			con = ConexaoUtil.getConexao();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TB_PEDIDO (DATA_PEDIDO,VL_VLAOR_PEDIDO,VL_TROCO,ID_PAGAMENTO, ID_CLIENTE,ID_FUNCIONARIO)");
		sql.append(" VALUES(?,?,?,?,?,?)");
		PreparedStatement stmt = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
		String dia = pedido.getDataPedido().substring(0,2);
		String mes = pedido.getDataPedido().substring(3,5);
		String ano = pedido.getDataPedido().substring(6,10);
		String data = ano+"-"+ mes+"-"+dia;
		stmt.setString(1, data);
		stmt.setDouble(2, pedido.getValorPedido());
		stmt.setDouble(3, pedido.getValorTroco());
		stmt.setInt(4, idPagamento);
		stmt.setInt(5, pedido.getIdcliente());
		stmt.setInt(6, pedido.getFuncionario());
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
	
	
	public List<PedidoDTO> listaPedidos() {
		List<PedidoDTO> listaPedidos = new ArrayList<PedidoDTO>();
		Connection conn = null;

		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT DISTINCT PEDIDO.ID_PEDIDO,PEDIDO.DATA_PEDIDO,CLIENTE.NM_CLIENTE, CLIENTE.SOBRENOME,");
			sql.append("	PEDIDO.VL_VLAOR_PEDIDO, PAGAMENTO.DS_TIPO_PAGAMENTO,");
			sql.append(" 	PAGAMENTO.VALOR_PAGAMENTO, PAGAMENTO.TROCO");
			sql.append("	FROM TB_PEDIDO PEDIDO INNER JOIN TB_PAGAMENTO PAGAMENTO ON PAGAMENTO.ID_PAGAMENTO = PEDIDO.ID_PAGAMENTO"); 
			sql.append("		INNER JOIN TB_CLIENTE CLIENTE ON CLIENTE.ID_CLIENTE = PEDIDO.ID_CLIENTE");
			sql.append("		INNER JOIN TB_ITEM_PEDIDO ITEM ON ITEM.ID_PEDIDO = PEDIDO.ID_PEDIDO");
			sql.append("		INNER JOIN TB_PRODUTO ON TB_PRODUTO.ID_PRODUTO = ITEM.ID_PRODUTO");
			sql.append("		INNER JOIN TB_TIPO_PRODUTO ON TB_TIPO_PRODUTO.ID_TIPO_PRODUTO = TB_PRODUTO.ID_TIPO_PRODUTO");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PedidoDTO pedido = new PedidoDTO();
				pedido.setIdPedido(rs.getInt("ID_PEDIDO"));
				pedido.setDataPedido(rs.getDate("DATA_PEDIDO"));
				pedido.setNomeCliente(rs.getString("NM_CLIENTE"));
				pedido.setSobrenome(rs.getString("SOBRENOME"));
				pedido.setValorPedido(rs.getDouble("VL_VLAOR_PEDIDO"));
				pedido.setTipoPagamento(rs.getString("DS_TIPO_PAGAMENTO"));
				pedido.setValorPagemnto(rs.getDouble("VALOR_PAGAMENTO"));
				pedido.setVlTroco(rs.getDouble("TROCO"));
				listaPedidos.add(pedido);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPedidos;
	}
	public List<PedidoDTO> filtrar() {
		List<PedidoDTO> listaPedidos = new ArrayList<PedidoDTO>();
		Connection conn = null;

		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT DISTINCT PEDIDO.ID_PEDIDO,PEDIDO.DATA_PEDIDO,CLIENTE.NM_CLIENTE, CLIENTE.SOBRENOME,");
			sql.append("	PEDIDO.VL_VLAOR_PEDIDO, PAGAMENTO.DS_TIPO_PAGAMENTO,");
			sql.append(" 	PAGAMENTO.VALOR_PAGAMENTO, PAGAMENTO.TROCO");
			sql.append("	FROM TB_PEDIDO PEDIDO INNER JOIN TB_PAGAMENTO PAGAMENTO ON PAGAMENTO.ID_PAGAMENTO = PEDIDO.ID_PAGAMENTO"); 
			sql.append("		INNER JOIN TB_CLIENTE CLIENTE ON CLIENTE.ID_CLIENTE = PEDIDO.ID_CLIENTE");
			sql.append("		INNER JOIN TB_ITEM_PEDIDO ITEM ON ITEM.ID_PEDIDO = PEDIDO.ID_PEDIDO");
			sql.append("		INNER JOIN TB_PRODUTO ON TB_PRODUTO.ID_PRODUTO = ITEM.ID_PRODUTO");
			sql.append("		INNER JOIN TB_TIPO_PRODUTO ON TB_TIPO_PRODUTO.ID_TIPO_PRODUTO = TB_PRODUTO.ID_TIPO_PRODUTO");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PedidoDTO pedido = new PedidoDTO();
				pedido.setIdPedido(rs.getInt("ID_PEDIDO"));
				pedido.setDataPedido(rs.getDate("DATA_PEDIDO"));
				pedido.setNomeCliente(rs.getString("NM_CLIENTE"));
				pedido.setSobrenome(rs.getString("SOBRENOME"));
				pedido.setValorPedido(rs.getDouble("VL_VLAOR_PEDIDO"));
				pedido.setTipoPagamento(rs.getString("DS_TIPO_PAGAMENTO"));
				pedido.setValorPagemnto(rs.getDouble("VALOR_PAGAMENTO"));
				pedido.setVlTroco(rs.getDouble("TROCO"));
				listaPedidos.add(pedido);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPedidos;
	}
}
