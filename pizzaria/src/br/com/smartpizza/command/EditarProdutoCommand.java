package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;

public class EditarProdutoCommand implements Command {
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.produtoDAO = new ProdutoDAO();
		String proximo  = "gerenciar-produto.jsp";
		
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		ProdutoDTO prod = produtoDAO.getProduto(idProduto);
		request.setAttribute("produto",prod );
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		request.setAttribute("produtos", listaProdutos);
		return proximo;
	}

}
