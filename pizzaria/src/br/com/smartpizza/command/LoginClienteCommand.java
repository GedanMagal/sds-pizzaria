package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.smartpizza.bo.UsuarioBO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Usuario;

public class LoginClienteCommand implements Command {
	private UsuarioDAO usuarioDAO;
	private PessoaDAO pessoaDAO;
	private PessoaDTO pessoaLog;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String proximo = "entrar.jsp";

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario user = new Usuario();
		user.setLogin(usuario);
		user.setSenha(senha);

		try {
			Usuario us = usuarioDAO.consultarUsuario(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proximo;

	}

}
