package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dto.PessoaDTO;

public class listarPedidos implements Command {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		String proxima = "realizar-pedido.jsp";
		
		List<PessoaDTO> lista = pessoaDAO.listaPessoas();
		request.setAttribute("pessoas", lista);
		return proxima;
	}

}
