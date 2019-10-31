package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;

public class PedidoCommand implements Command {
	private SaborDAO saborDAO;
	private IngredientaDAO ingreDAO;
	private ProdutoDAO produtoDAO;
	private PessoaDAO pessoaDAO;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		this.saborDAO = new SaborDAO();
		this.ingreDAO = new IngredientaDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		String proximo = "realizar-pedido.jsp";
		
	
		List<Sabor> sabores = saborDAO.listaSAbores();
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		List<PessoaDTO> pessoa = pessoaDAO.listaPessoas();
		request.setAttribute("produtos", listaProdutos);
		request.getSession().setAttribute("sabores", sabores);
		request.setAttribute("pessoas", pessoa);
	
		return proximo;
	}

}
