package br.com.smartsds.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dao.SaborIngredienteDAO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.IngredienteSabor;
import br.com.smartpizza.model.Sabor;

public class CadastrarSaboresPizza implements Command{
	private Sabor saborObj;
	private SaborDAO saborDAO;
	private IngredientaDAO igrDAO;
	private SaborIngredienteDAO sabIngrDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.saborObj = new Sabor();
		this.saborDAO = new SaborDAO();
		this.igrDAO = new IngredientaDAO();
		this.sabIngrDAO = new SaborIngredienteDAO();
		String proximo ="cadastrarSaboresPizza.jsp";
		int idIngre  = 0;
		String sabor =  request.getParameter("sabor");
		String[] ingredientes = request.getParameterValues("ingredientes");
		saborObj.setDsSabor(sabor);
		Ingrediente ingrediente  =  new Ingrediente();
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		 for(String ing: ingredientes) {
			 ingrediente.setDsIngrediente(ing);
			 ingrediente.setRequerido(true);
			 listaIngred.add(ingrediente);
			 igrDAO.insereIngredienteSabor(ingrediente);
			  idIngre = igrDAO.findMaxId();
		 }
		saborObj.setIngredientes(listaIngred);
		saborDAO.cadastrarSabores(saborObj);
		int idSabor = saborDAO.findMaxId();
		
		IngredienteSabor ingrSabor = new IngredienteSabor(idIngre, idSabor);
		sabIngrDAO.salvar(ingrSabor);
		return proximo;
	}
	

}
