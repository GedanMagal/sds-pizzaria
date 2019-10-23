package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MontaProduto implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String proximo = "";
		
			String tamanho = request.getParameter("tamnho");
			String nomeprodudo = "pizza";
			
		return null;
	}

}
