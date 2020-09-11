package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Produto;

public class EditarProdutoCommand implements Command {
	private ProdutoDAOImpl produtoDAO;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		String proximo  = "gerenciar-produto.jsp";
		
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		Produto prod = produtoDAO.findById((long) idProduto);
		request.setAttribute("produto",prod );
		List<Produto> listaProdutos = produtoDAO.listAll();
		request.setAttribute("produtos", listaProdutos);
		return proximo;
	}

}
