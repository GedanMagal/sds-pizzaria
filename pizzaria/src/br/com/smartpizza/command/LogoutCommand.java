package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		request.setAttribute("msgSucesso", "Volte Sempre!");
		return "login.jsp";
	}
	
}

