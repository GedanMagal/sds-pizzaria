package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;

public class PedidoCommand implements Command {
	private SaborDAO saborDAO;
	private IngredientaDAO ingreDAO;
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		this.saborDAO = new SaborDAO();
		this.ingreDAO = new IngredientaDAO();
		this.produtoDAO = new ProdutoDAO();
		String proximo = "pedido.jsp";
		
		int idCliente =  Integer.parseInt(request.getParameter("idCliente"));
		List<Sabor> sabores = saborDAO.listaSAbores();
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		request.setAttribute("produtos", listaProdutos);
		request.getSession().setAttribute("sabores", sabores);
		
	
		return proximo;
	}

}
