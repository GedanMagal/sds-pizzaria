package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.model.Estado;

public class ListaEstadosCommand implements Command {
	@Autowired
	private EstadoDAO estadoDAO;
	
	
	
	private String proxima;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String permission = request.getParameter("admin");
		
		if(permission.equals("true")) {
			proxima ="cadastrar-cliente.jsp";
			List<Estado> listEstados = estadoDAO.listAll();
			request.setAttribute("estados", listEstados);
		} else {
			proxima ="cadastroCliente.jsp";
			List<Estado> listEstados = estadoDAO.listAll();
			request.setAttribute("estados", listEstados);
		}
	
		return proxima;
		
	}

}
