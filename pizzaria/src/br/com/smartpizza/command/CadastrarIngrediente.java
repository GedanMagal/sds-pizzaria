package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.model.Ingrediente;

public class CadastrarIngrediente implements Command {
	private IngredientaDAO igrDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.igrDAO = new IngredientaDAO();
		String proximo = "admin?acao=cadastrarSaborPizza";
		String[] ingredientes = request.getParameterValues("ingredientes");
		
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		 for(String ing: ingredientes) {
			 Ingrediente ingrediente = new Ingrediente();
			 ingrediente.setDsIngrediente(ing);
			 ingrediente.setRequerido(true);
			 listaIngred.add(ingrediente);
			 igrDAO.insereIngredienteSabor(ingrediente);
		}
		
		return proximo;
	}

}
