package br.com.smartpizza.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.CadastroPessoaCommand;
import Command.Command;
import Command.EditarClienteCommand;
import Command.ListaEstadosCommand;
import Command.SalvarClienteCommand;
import Command.listarCliente;


@WebServlet("/servlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		comandos.put("salvarCLiente", new SalvarClienteCommand());
		comandos.put("listaEstados", new ListaEstadosCommand());
		comandos.put("listarClientes", new listarCliente());
		comandos.put("editarCliente", new EditarClienteCommand());
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String acao = request.getParameter("acao");
		String proxima = null;
		try {
			Command comando = verificarComand(acao);
			proxima = comando.execute(request);
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		request.getRequestDispatcher(proxima).forward(request, response);
	}
	
	private Command verificarComand(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
		
		
		
	
}
