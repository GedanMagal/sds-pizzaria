package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesqisaCliente implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String pesqisa = request.getParameter("pesquisa");
		return null;
	}

}
