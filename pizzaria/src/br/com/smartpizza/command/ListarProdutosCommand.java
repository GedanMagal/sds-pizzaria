package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.Tamanho;
import br.com.smartpizza.model.TipoProduto;

public class ListarProdutosCommand implements Command {
	private ProdutoDAO produtoDAO;
	private TipoProdutoDAO tipoDAO;
	private SaborDAO saborDAO;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
		this.tipoDAO = new TipoProdutoDAO();
		this.saborDAO = new SaborDAO();
		String proximo = "gerenciar-produto.jsp";
		String produto = request.getParameter("produto");
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		List<ProdutoDTO> listaPizza = produtoDAO.listarProdutospizza("pizza +1 sabor");
		List<Sabor> sabores = saborDAO.listaSAbores();

		request.setAttribute("produtos", listaProdutos);
		request.getSession().setAttribute("sabores", sabores);
		
		List<TipoProduto> tipos = tipoDAO.listaTipos();
		request.setAttribute("produtos", listaPizza);
		request.setAttribute("tiposProdutos", tipos);
	
		
		
		return proximo;
	}

}
