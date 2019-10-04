package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.model.Estado;

public class ListaEstadosCommand implements Command {
	private EstadoDAO estadoDAO = new EstadoDAO();
	
	
	
	private String proxima;
	@Override
	public String execute(HttpServletRequest request) {
		
		String permission = request.getParameter("admin");
		
		if(permission.equals("true")) {
			proxima ="cadastrar-cliente.jsp";
			List<Estado> listEstados = estadoDAO.listarEstados();
			request.setAttribute("estados", listEstados);
		} else {
			proxima ="cadastroCliente.jsp";
			List<Estado> listEstados = estadoDAO.listarEstados();
			request.setAttribute("estados", listEstados);
		}
	
		return proxima;
		
	}

}
