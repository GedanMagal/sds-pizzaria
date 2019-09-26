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
		Integer idProduto = null;
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
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.first()) {
				idProduto = rs.getInt(1);
			}
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
			sql.append("SELECT pro.id_produto, pro.nm_produto, pro.ds_tamanho, pro.valor_produto,est.qtd_estoque, tip.ds_tipo_produtocol");
			sql.append(" from tb_produto pro inner join tb_estoque est on pro.id_estoque = est.id_estoque");
			sql.append("  inner join tb_tipo_produto tip on tip.id_tipo_produto = pro.id_tipo_produto");
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
					ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ProdutoDTO p = new ProdutoDTO();
				p.setIdProduto(rs.getInt("id_produto"));
				p.setNomeProduto(rs.getString("nm_produto"));
				p.setTamanho(rs.getString("ds_tamanho"));
				p.setValorProduto(rs.getFloat("valor_produto"));
				p.setQuantidade(rs.getInt("qtd_estoque"));
				p.setDsTipo(rs.getString("ds_tipo_produtocol"));
				listaProdutos.add(p);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaProdutos;
	}
}
