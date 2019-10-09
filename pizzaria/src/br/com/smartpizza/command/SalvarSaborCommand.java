package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;

public class SalvarSaborCommand implements Command{
	private String proximo;
	private Sabor saborObj;
	private SaborDAO saborDAO;
	private IngredientaDAO ingredienteDAO; 
	@Override
	public String execute(HttpServletRequest request) {
		this.saborObj = new Sabor();
		this.ingredienteDAO = new  IngredientaDAO();
		this.saborDAO = new SaborDAO();
		this.saborObj = new Sabor();

	

		String proximo ="admin?acao=cadastrarSaborPizza";
		
		String sabor =  request.getParameter("sabor");
		String[] ingredientes = request.getParameterValues("ingredientes");
		
		Ingrediente ingrediente  =  new Ingrediente();
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		
		 for(String ing: ingredientes) {
			Ingrediente ingr = new Ingrediente();
			ingr.setIdIngrediente(Integer.parseInt(ing));
			listaIngred.add(ingr);
		}
		 saborObj.setDsSabor(sabor);
		 saborObj.setIngredientes(listaIngred);
		 saborDAO.cadastrarSabores(saborObj);

		
		
		return proximo;
	}

}
