package Command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Sabor;

public class CadastrarSaboresPizza implements Command{
	private Sabor saborObj;
	private SaborDAO saborDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.saborObj = new Sabor();
		this.saborDAO = new SaborDAO();
		String proximo ="cadastraSaboresPizza.jsp";
		
		String sabor =  request.getParameter("sabor");
		String[] ingredientes = request.getParameterValues("ingredientes");
		saborObj.setDsSabor(sabor);
		Ingrediente ingrediente  =  new Ingrediente();
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		 for(String ing: ingredientes) {
			 ingrediente.setDsIngrediente(ing);
			 listaIngred.add(ingrediente);
		 }
		saborObj.setIngredientes(listaIngred);
		saborDAO.cadastrarSabores(saborObj);
		return null;
	}
	

}
