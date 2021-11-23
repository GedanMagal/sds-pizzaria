package br.com.smartpizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.util.ConexaoUtil;

public class ProdutoDAO {

	private SaborDAO saborDAO = new SaborDAO();
	private EstoqueDAO estoque = new EstoqueDAO();
	
	public Integer cadastrarProduto(Produto produto) {
		Connection conn = null;
		
		Integer idProduto = null;
		StringBuilder sql =  new StringBuilder();
		try {
			
			conn = ConexaoUtil.getConexao();
			sql.append("INSERT INTO TB_PRODUTO (nm_produto, ds_tamanho, valor_produto, id_estoque, id_tipo_produto)");
			sql.append(" VALUES(?,?,?,?,?)");
	
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getTamanho());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, produto.getEstoque().getIdEstoque());
			stmt.setInt(5, produto.getTipoProduto().getIdTipoProduto());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				idProduto = rs.getInt(1);
			}
			saborDAO.cadastrarSabores(produto.getSabor(), idProduto);
			
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idProduto;
	}
	public Integer cadastrarProdutoBebidas(Produto produto) {
		Connection conn = null;
		
		Integer idProduto = null;
		StringBuilder sql =  new StringBuilder();
		try {
			Integer idEstoque = estoque.cadastroEstoque(produto.getEstoque());
			conn = ConexaoUtil.getConexao();
			sql.append("INSERT INTO TB_PRODUTO (nm_produto, ds_tamanho, valor_produto, id_estoque, id_tipo_produto)");
			sql.append(" VALUES(?,?,?,?,?)");
	
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getTamanho());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, idEstoque);
			stmt.setInt(5, produto.getTipoProduto().getIdTipoProduto());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				idProduto = rs.getInt(1);
			}
			
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idProduto;
	}
	
	public List<ProdutoDTO> listarProdutospizza( int tipo){
		List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
		Connection conn = null;
		
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT PRO.ID_PRODUTO, PRO.NM_PRODUTO, PRO.DS_TAMANHO, PRO.VALOR_PRODUTO,EST.QTD_ESTOQUE, TIP.DS_TIPO_PRODUTO, SABOR.DS_SABOR"); 
			sql.append(" FROM TB_PRODUTO PRO");
			sql.append(" INNER JOIN TB_PRODUTO_SABOR PS on PS.ID_PRODUTO = PRO.ID_PRODUTO");
			sql.append("   INNER JOIN TB_SABOR SABOR on SABOR.ID_SABOR = PS.ID_SABOR");
			sql.append("	INNER JOIN TB_ESTOQUE EST ON PRO.ID_ESTOQUE = EST.ID_ESTOQUE"); 
			sql.append(" 	INNER JOIN TB_TIPO_PRODUTO TIP ON TIP.ID_TIPO_PRODUTO = PRO.ID_TIPO_PRODUTO"); 
			sql.append("  WHERE TIP.ID_TIPO_PRODUTO = ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, tipo);
		

					ResultSet rs = stmt.executeQuery();
					while(rs.next()) {
				ProdutoDTO p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produto"));
				listaProdutos.add(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaProdutos;
	}
	
	public List<ProdutoDTO> listarProdutoPizzaBroto(String tipo, int id,String tamanho){
		List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
		Connection conn = null;
		
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT PRO.ID_PRODUTO, PRO.NM_PRODUTO, PRO.DS_TAMANHO, PRO.VALOR_PRODUTO,EST.QTD_ESTOQUE, TIP.DS_TIPO_PRODUTO");
			sql.append(" FROM TB_PRODUTO PRO INNER JOIN TB_ESTOQUE EST ON PRO.ID_ESTOQUE = EST.ID_ESTOQUE");
			sql.append("  INNER JOIN TB_TIPO_PRODUTO TIP ON TIP.ID_TIPO_PRODUTO = PRO.ID_TIPO_PRODUTO");
			sql.append("  WHERE PRO.NM_PRODUTO NOT LIKE ? and TIP.ID_TIPO_PRODUTO = ? and PRO.DS_TAMANHO like  ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			
					
					stmt.setString(1, "%"+tipo+"%");
					stmt.setInt(2, id);
					stmt.setString(3, "%"+tamanho+"%");
					ResultSet rs = stmt.executeQuery();
					while(rs.next()) {
				ProdutoDTO p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produto"));
				listaProdutos.add(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaProdutos;
	}
	public List<ProdutoDTO> listarProdutos(){
		List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
		Connection conn = null;
		
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT PRO.ID_PRODUTO, PRO.NM_PRODUTO, PRO.DS_TAMANHO, PRO.VALOR_PRODUTO,EST.QTD_ESTOQUE, TIP.DS_TIPO_PRODUTO");
			sql.append(" FROM TB_PRODUTO PRO INNER JOIN TB_ESTOQUE EST ON PRO.ID_ESTOQUE = EST.ID_ESTOQUE");
			sql.append("  INNER JOIN TB_TIPO_PRODUTO TIP ON TIP.ID_TIPO_PRODUTO = PRO.ID_TIPO_PRODUTO");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
					ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ProdutoDTO p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produto"));
				listaProdutos.add(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaProdutos;
	}
	
	public void updatePrecoPizza(Integer idPreco) {
		Connection conn = null;
		
		StringBuilder sql =  new StringBuilder();
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("update TB_PRODUTO SET VALOR_PRODUTO = (select max(sabor.VALOR) from TB_SABOR sabor"); 
			sql.append(" inner join TB_PRODUTO_SABOR PS on PS.ID_SABOR = sabor.ID_SABOR)");
			sql.append(" where ID_PRODUTO = ?");
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			
			Produto produto  = new Produto();

			stmt.setInt(1, idPreco);
			stmt.executeUpdate();
			
			
			conn.close();
			stmt.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatePrecoPizzaBroto(Integer idPreco, double preco) {
		Connection conn = null;
		
		StringBuilder sql =  new StringBuilder();
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("update TB_PRODUTO SET VALOR_PRODUTO = ?");
			sql.append(" where ID_PRODUTO = ?");
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			
			Produto produto  = new Produto();
			stmt.setDouble(1, preco);
			stmt.setInt(2, idPreco);
			stmt.executeUpdate();
			
			
			conn.close();
			stmt.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizarProduto(Produto produto) {
		Connection conn = null;
		
		StringBuilder sql =  new StringBuilder();
		try {
			conn = ConexaoUtil.getConexao();
			sql.append("UPDATE TB_PRODUTO SET nm_produto = ?, ds_tamanho =?, valor_produto = ?, id_estoque ?, id_tipo_produto = ? ");
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getTamanho());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, produto.getEstoque().getIdEstoque());
			stmt.setInt(5, produto.getTipoProduto().getIdTipoProduto());
			stmt.execute();
			
			
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ProdutoDTO getProdutoById(Integer idProduto){
		Connection conn = null;
		ProdutoDTO p = null;
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT PRO.ID_PRODUTO, PRO.NM_PRODUTO, PRO.DS_TAMANHO, PRO.VALOR_PRODUTO,EST.QTD_ESTOQUE, TIP.DS_TIPO_PRODUTO");
			sql.append(" FROM TB_PRODUTO PRO INNER JOIN TB_ESTOQUE EST ON PRO.ID_ESTOQUE = EST.ID_ESTOQUE");
			sql.append("  INNER JOIN TB_TIPO_PRODUTO TIP ON TIP.ID_TIPO_PRODUTO = PRO.ID_TIPO_PRODUTO");
			sql.append("  WHERE ID_PRODUTO = ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
					
			stmt.setInt(1, idProduto);
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				 p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produto"));
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return p;
	}
	public List<ProdutoDTO> getProdutoByName(String nome){
		List<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();
		Connection conn = null;
		
		try {
			conn = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT PRO.ID_PRODUTO, PRO.NM_PRODUTO, PRO.DS_TAMANHO, PRO.VALOR_PRODUTO,EST.QTD_ESTOQUE, TIP.DS_TIPO_PRODUTO");
			sql.append(" FROM TB_PRODUTO PRO INNER JOIN TB_ESTOQUE EST ON PRO.ID_ESTOQUE = EST.ID_ESTOQUE");
			sql.append("  INNER JOIN TB_TIPO_PRODUTO TIP ON TIP.ID_TIPO_PRODUTO = PRO.ID_TIPO_PRODUTO");
			sql.append("  WHERE ID_PRODUTO = ?");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
					
			stmt.setString(1, nome+"%");
			ResultSet rs = stmt.executeQuery();
			if(rs.first()) {
				ProdutoDTO p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produto"));
				listaProdutos.add(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaProdutos;
	}
}
