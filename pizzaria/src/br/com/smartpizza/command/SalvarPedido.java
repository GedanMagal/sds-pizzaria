package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.TipoProduto;

public class SalvarPedido implements Command {
	private ProdutoDAO produtoDAO;
	private TipoProdutoDAO tipoDAO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
		this.tipoDAO = new TipoProdutoDAO();
		String proximo = "pedido.jsp";
		int produto = Integer.parseInt(request.getParameter("produto"));
		String sabor[] = request.getParameterValues("sabor");
		String ingredientes[] = request.getParameterValues("ingredientes");
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		List<TipoProduto> tipos = tipoDAO.listaTipos();
		
		request.setAttribute("produtos", listaProdutos);
		request.setAttribute("tiposProdutos", tipos);
	
		return proximo;
	}

}
