package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarPedido implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String proximo = "pedido.jsp";
		String sabor[] = request.getParameterValues("sabor");
		String ingredientes[] = request.getParameterValues("ingredientes");
		
		return proximo;
	}

}
