package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.model.Pessoa;

public class listarPedidos implements Command {
	private PessoaDAOImpl pessoaDAO = new PessoaDAOImpl();
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		String proxima = "realizar-pedido.jsp";
		
		List<Pessoa> lista = pessoaDAO.listAll();
		request.setAttribute("pessoas", lista);
		return proxima;
	}

}
