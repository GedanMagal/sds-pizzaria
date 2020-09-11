package br.com.smartpizza.command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.model.Pessoa;

public class EditarClienteCommand implements Command {
	@Autowired
	private PessoaDAOImpl pessoaDAO;
	private String proxima;
	@Autowired
	private EstadoDAO estadoDAO;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		proxima = "editar-cliente.jsp";
		this.pessoaDAO = new PessoaDAOImpl();
		this.estadoDAO = new EstadoDAO();
		try {
			
		Long idcliente = Long.parseLong(request.getParameter("idCliente"));
		Pessoa p = pessoaDAO.findById(idcliente);
		List<Estado> listaEstado = estadoDAO.listAll();
		request.setAttribute("estados", listaEstado);
		request.setAttribute("pessoa", p);
		}catch(Exception e) {
			request.setAttribute("msg", "erro ao recuperar cliente"+ e);
		}
	
		return proxima;
	}

}
