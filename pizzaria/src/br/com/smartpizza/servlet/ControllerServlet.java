package br.com.smartpizza.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.command.AdicionaCArrinhoCommand;
import br.com.smartpizza.command.AtualizarClienteCommand;
import br.com.smartpizza.command.CadastrarClienteCommand;
import br.com.smartpizza.command.CadastrarFuncionarioCommand;
import br.com.smartpizza.command.CadastrarIngrediente;
import br.com.smartpizza.command.CadastrarSaboresPizza;
import br.com.smartpizza.command.CadastroProdutoCommand;
import br.com.smartpizza.command.Command;
import br.com.smartpizza.command.EditarClienteCommand;
import br.com.smartpizza.command.EditarProdutoCommand;

import br.com.smartpizza.command.ListarProdutosCommand;
import br.com.smartpizza.command.LoginAdmCommand;
import br.com.smartpizza.command.LoginClienteCommand;
import br.com.smartpizza.command.LogoutCommand;
import br.com.smartpizza.command.RealizarPedido;
import br.com.smartpizza.command.SalvarPedido;
import br.com.smartpizza.command.SalvarSaborCommand;
import br.com.smartpizza.command.listarCliente;


@WebServlet(urlPatterns = {"/admin/admin", "/client"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		comandos.put("salvarCliente", new CadastrarClienteCommand());
		comandos.put("listarClientes", new listarCliente());
		comandos.put("editarCliente", new EditarClienteCommand());
		comandos.put("atualizarCliente", new AtualizarClienteCommand());
		comandos.put("salvarFuncionario", new CadastrarFuncionarioCommand());
		comandos.put("cadastrarProduto", new CadastroProdutoCommand());
		comandos.put("listaprodutos", new ListarProdutosCommand());
		comandos.put("cadastrarSaborPizza", new CadastrarSaboresPizza());
		comandos.put("SalvarSaborPizza", new SalvarSaborCommand());
		comandos.put("editarProduto", new EditarProdutoCommand());
		comandos.put("logout", new LogoutCommand());
		comandos.put("cadastarIngrediente", new CadastrarIngrediente());
		comandos.put("salvarPedido", new SalvarPedido());
		comandos.put("realizarPedido", new RealizarPedido());
		comandos.put("loginUser", new LoginAdmCommand());
		comandos.put("loginCliente", new LoginClienteCommand());
		
	
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String acao = request.getParameter("acao");
		String proxima = null;
		try {
			Command comando = verificarComand(acao);
			proxima = comando.execute(request,response);
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
