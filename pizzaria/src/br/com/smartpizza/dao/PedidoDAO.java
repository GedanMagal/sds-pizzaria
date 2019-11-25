package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.util.ConexaoUtil;


public class PedidoDAO {
	
	public Integer cadastrarPedido(Pedido pedido) {
		Connection con = null;
		Integer idPedido = null;
		Integer idPagamento = null;
		try {
			idPagamento = new PagamentoDAO().cadastrarPagamento(pedido.getPagamento());
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
	
	
//	public List<PedidosDTO> listaPedidos() {
//		List<PedidosDTO> listaPedidos = new ArrayList<PedidosDTO>();
//		Connection conn = null;
//
//		try {
//			conn = ConexaoUtil.getConexao();
//			StringBuilder sql = new StringBuilder();
//			sql.append("SELECT CLI.ID_CLIENTE, CLI.NM_CLIENTE,CLI.SOBRENOME,CLI.DS_EMAIL, CLI.CLI_TELEFONE, CLI.CLI_CELULAR,EN.DS_LOGRADOURO, EN.NM_ENDERECO, EN.NM_CEP,EN.DS_BAIRRO");
//			sql.append(" FROM TB_CLIENTE CLI INNER JOIN  TB_ENDERECO EN ON EN.ID_CLIENTE = CLI.ID_CLIENTE");
//			PreparedStatement stmt = conn.prepareStatement(sql.toString());
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				PessoaDTO p = new PessoaDTO();
//				p.setIdPessoa(rs.getInt("CLI.ID_CLIENTE"));
//				p.setNome(rs.getString("NM_CLIENTE"));
//				p.setSobrenome(rs.getString("SOBRENOME"));
//				p.setEmail(rs.getString("DS_EMAIL"));
//				p.setTelefone(rs.getString("CLI_TELEFONE"));
//				p.setCelular(rs.getString("CLI_CELULAR"));
//				p.setEndereco(rs.getString("DS_LOGRADOURO"));
//				p.setNumero(rs.getString("NM_ENDERECO"));
//				p.setCep(rs.getString("NM_CEP"));
//				p.setBairro(rs.getString("DS_BAIRRO"));
//				listPessoas.add(p);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listPessoas;
//	}
}
