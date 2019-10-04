package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
	
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		request.setAttribute("msgSucesso", "Volte Sempre!");
		return "login.jsp";
	}
	
}

