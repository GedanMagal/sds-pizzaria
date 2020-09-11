package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.TipoProduto;

public class ListarProdutosCommand implements Command {
	@Autowired
	private ProdutoDAOImpl produtoDAO;
	@Autowired
	private TipoProdutoDAO tipoDAO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String proximo = "gerenciar-produto.jsp";
		String produto = request.getParameter("produto");
		List<Produto> listaProdutos = produtoDAO.listAll();
		List<Produto> listaPizza = produtoDAO.findBySizeAndType("Pizza", 1L);
		List<Produto> broto = produtoDAO.findBySizeAndType("Pizza", 1L);

		request.setAttribute("produtos", listaProdutos);
		request.setAttribute("broto", broto);

		List<TipoProduto> tipos = tipoDAO.listAll();
		request.setAttribute("produtos", listaPizza);
		request.setAttribute("tiposProdutos", tipos);

		return proximo;
	}

}
