package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.model.Ingrediente;
@WebServlet(urlPatterns = {"/admin/saborServlet","/saborServlet"})
public class ListaIngredientes extends HttpServlet {

	private static final long serialVersionUID = -2907232175023620317L;
	private SaborDAO saborDAO;
	private IngredientaDAO ingreDAO;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.saborDAO = new SaborDAO();
		this.ingreDAO = new IngredientaDAO();
		int idSabor = Integer.parseInt(req.getParameter("idSabor"));
		
		List<Ingrediente> ingredientes = ingreDAO.listIngredienteSabor(idSabor);
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder("");
		if(ingredientes!=null) {
			for(int i=0;i<ingredientes.size();i++) {
			sb.append(ingredientes.get(i).getIdIngrediente()+ "-" + ingredientes.get(i).getDsIngrediente()+":");
		}
			out.write(sb.toString());
		}
		
	}

}
