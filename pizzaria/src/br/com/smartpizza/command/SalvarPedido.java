package br.com.smartpizza.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarPedido implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int idProduto =  Integer.parseInt(request.getParameter("produto"));
		int idCliente =  Integer.parseInt(request.getParameter("idCLiente"));
		String proximo = "pedido.jsp";
		String sabor[] = request.getParameterValues("sabor");
		String ingredientes[] = request.getParameterValues("ingredientes");
		
		return proximo;
	}

}
