package br.com.smartsds.command;

import javax.servlet.http.HttpServletRequest;

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
	public String execute(HttpServletRequest request);
}
