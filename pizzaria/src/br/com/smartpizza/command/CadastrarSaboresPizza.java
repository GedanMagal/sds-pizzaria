package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.SaborDAO;

import br.com.smartpizza.model.Ingrediente;

import br.com.smartpizza.model.Sabor;

public class CadastrarSaboresPizza implements Command{

	private IngredientaDAO igrDAO;

	@Override
	public String execute(HttpServletRequest request) {
		this.igrDAO = new IngredientaDAO();
		String proximo = "cadastrarSaboresPizza.jsp";
		List<Ingrediente> listaLingredientes =  igrDAO.listaIngredientes();
		
		request.setAttribute("lista", listaLingredientes);
		return proximo;
	}
	

}
