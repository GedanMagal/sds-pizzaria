package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Tamanho;
import br.com.smartpizza.model.TipoProduto;

public class ListarProdutosCommand implements Command {
	private ProdutoDAO produtoDAO;
	private TipoProdutoDAO tipoDAO;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
		this.tipoDAO = new TipoProdutoDAO();
		
		String proximo = "gerenciar-produto.jsp";
		String produto = request.getParameter("produto");
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		List<ProdutoDTO> listaPizza = produtoDAO.listarProdutospizza("pizza");
		List<TipoProduto> tipos = tipoDAO.listaTipos();
		request.setAttribute("produtos", listaProdutos);
		request.setAttribute("tiposProdutos", tipos);
	
		
		
		return proximo;
	}

}
