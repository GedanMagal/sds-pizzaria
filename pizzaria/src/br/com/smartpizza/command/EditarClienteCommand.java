package br.com.smartpizza.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Estado;

public class EditarClienteCommand implements Command {
	private PessoaDAO pessoaDAO;
	private String proxima;
	private EstadoDAO estadoDAO;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		proxima = "editar-cliente.jsp";
		this.pessoaDAO = new PessoaDAO();
		this.estadoDAO = new EstadoDAO();
		try {
			
		Integer idcliente = Integer.parseInt(request.getParameter("idCliente"));
		PessoaDTO p = pessoaDAO.getPessoa(idcliente);
		List<Estado> listaEstado = estadoDAO.listarEstados();
		request.setAttribute("estados", listaEstado);
		request.setAttribute("pessoa", p);
		}catch(Exception e) {
			request.setAttribute("msg", "erro ao recuperar cliente"+ e);
		}
	
		return proxima;
	}

}
