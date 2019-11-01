package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesquisaCliente implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String pesquisa = request.getParameter("pesquisa");
		return null;
	}

}
