package br.com.smartpizza.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Command.Command;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dto.PessoaDTO;

public class listarCliente implements Command {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	@Override
	public String execute(HttpServletRequest request) {
		String proxima = "/admin/gerenciar-cliente.jsp";
		
		List<PessoaDTO> lista = pessoaDAO.listaPessoas();
		request.setAttribute("pessoas", lista);
		return proxima;
	}

}
