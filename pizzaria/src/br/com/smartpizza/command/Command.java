package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface para o padr�o Command
 * 
 * @author Devmedia
 * 
 */
public interface Command {

	/**
	 * Metodo de execução do comando
	 * 
	 * @param request
	 * @return
	 */
	public String execute(HttpServletRequest request,HttpServletResponse response);
}
