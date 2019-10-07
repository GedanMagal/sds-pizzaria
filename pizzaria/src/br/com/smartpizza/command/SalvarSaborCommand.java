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
	private IngredientaDAO ingredienteDAO; 
	@Override
	public String execute(HttpServletRequest request) {
		this.saborObj = new Sabor();
		this.ingredienteDAO = new  IngredientaDAO();
		
		this.saborObj = new Sabor();

	

		String proximo ="cadastrarSaboresPizza.jsp";
		
		String sabor =  request.getParameter("sabor");
		String[] ingredientes = request.getParameterValues("ingredientes");
		saborObj.setDsSabor(sabor);
		Ingrediente ingrediente  =  new Ingrediente();
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		
		 for(String ing: ingredientes) {
			
			 ingrediente.setDsIngrediente(ing);
			 ingrediente.setRequerido(true);
			 listaIngred.add(ingrediente);
			
			
			 
			
  
		}

		 saborObj.setIngredientes(listaIngred);
		 

		
		
		return proximo;
	}

}
