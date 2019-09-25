package br.com.smartpizza.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Command.EditarClienteCommand;
import Command.ListaEstadosCommand;
import Command.LoginClienteCommand;
import Command.atualizarClienteCommand;
import Command.CadastrarClienteCommand;
import Command.CadastrarFuncionarioCommand;
import Command.listarCliente;
import Command.loginAdmCommand;


@WebServlet(urlPatterns = {"/admin/admin", "/client"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		comandos.put("salvarCliente", new CadastrarClienteCommand());
		comandos.put("listarClientes", new listarCliente());
		comandos.put("editarCliente", new EditarClienteCommand());
		comandos.put("atualizarCliente", new atualizarClienteCommand());
		comandos.put("salvarFuncionario", new CadastrarFuncionarioCommand());
		
		//comandos.put("listaEstados", new ListaEstadosCommand());
		
		comandos.put("loginUser", new loginAdmCommand());
		comandos.put("loginC", new LoginClienteCommand());
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
