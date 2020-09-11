package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.model.Pessoa;
import br.com.smartpizza.model.Produto;

public class RealizarPedido implements Command {
	private ProdutoDAOImpl produtoDAO;
	private PessoaDAOImpl pessoa;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		this.pessoa = new PessoaDAOImpl();
		String proximo = "realizar-pedido.jsp";
		List<Pessoa> pessoas = pessoa.listAll();
		List<Produto> listaProdutos =  produtoDAO.listAll();
		List<Produto> listaProdutosbroto =  produtoDAO.listAll();
		request.setAttribute("prd", listaProdutos);
		request.setAttribute("brotos", listaProdutosbroto);
		request.getSession().setAttribute("pessoas", pessoas);
		return proximo;
	}

}
