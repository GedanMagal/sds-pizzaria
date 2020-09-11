package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.model.Ingrediente;

public class SalvarSaborCommand implements Command{
	private String proximo;
	@Autowired
	private IngredientaDAO ingredienteDAO; 
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
	
		
		String proximo ="admin?acao=cadastrarSaborPizza";
		
		String sabor =  request.getParameter("sabor");
		String valor = request.getParameter("valor");
		String[] ingredientes = request.getParameterValues("ingredientes");
		
		Ingrediente ingrediente  =  new Ingrediente();
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		
		 for(String ing: ingredientes) {
			Ingrediente ingr = new Ingrediente();
			ingr.setIdIngrediente((long) Integer.parseInt(ing));
			listaIngred.add(ingr);
		}
		 

		
		
		return proximo;
	}

}
