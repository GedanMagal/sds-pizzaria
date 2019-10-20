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
	private EstoqueDAO estoqueDAO;
	private SaborDAO saborDAO;
	public void cadastrarProduto(Produto produto) {
		Connection conn = null;
		estoqueDAO = new EstoqueDAO();
		StringBuilder sql =  new StringBuilder();
		try {
			Integer idEstoque = estoqueDAO.cadastroEstoque(produto.getEstoque());
			conn = ConexaoUtil.getConexao();
			sql.append("INSERT INTO TB_PRODUTO (nm_produto, ds_tamanho, valor_produto, id_estoque, id_tipo_produto) ");
			sql.append("VALUES(?,?,?,?,?)");
	
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getTamanho());
			stmt.setFloat(3, produto.getValor());
			stmt.setInt(4, idEstoque);
			stmt.setInt(5, produto.getTipoProduto().getIdTipoProduto());
			stmt.execute();
			
			
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void atualizarProduto(Produto produto) {
		Connection conn = null;
		estoqueDAO = new EstoqueDAO();
		StringBuilder sql =  new StringBuilder();
		try {
			Integer idEstoque = estoqueDAO.cadastroEstoque(produto.getEstoque());
			conn = ConexaoUtil.getConexao();
			sql.append("UPDATE TB_PRODUTO SET nm_produto = ?, ds_tamanho =?, valor_produto = ?, id_estoque ?, id_tipo_produto = ? ");
			
			PreparedStatement stmt = conn.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getTamanho());
			stmt.setFloat(3, produto.getValor());
			stmt.setInt(4, idEstoque);
			stmt.setInt(5, produto.getTipoProduto().getIdTipoProduto());
			stmt.execute();
			
			
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ProdutoDTO getProduto(Integer idProduto){
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
}
