package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.model.Ingrediente;

public class CadastrarSaboresPizza implements Command{

	private IngredientaDAO igrDAO;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		this.igrDAO = new IngredientaDAO();
		String proximo = "cadastrarSaboresPizza.jsp";
		List<Ingrediente> listaLingredientes =  igrDAO.listAll();
		
		request.setAttribute("lista", listaLingredientes);
		return proximo;
	}
	

}
