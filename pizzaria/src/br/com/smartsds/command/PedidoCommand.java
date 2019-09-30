package br.com.smartsds.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;

public class PedidoCommand implements Command {
	private SaborDAO saborDAO;
	private IngredientaDAO ingreDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.saborDAO = new SaborDAO();
		String proximo = "pedido.jsp";
		
		int idCliente =  Integer.parseInt(request.getParameter("idCliente"));
		List<Sabor> sabores = saborDAO.listaSAbores();
		
		request.setAttribute("sabores", sabores);
		return proximo;
	}

}
