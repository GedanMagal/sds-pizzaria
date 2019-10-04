package br.com.smartpizza.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.smartpizza.bo.UsuarioBO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Usuario;

public class LoginClienteCommand implements Command{
	private UsuarioDAO usuarioDAO;
	private PessoaDAO pessoaDAO;
	private PessoaDTO  pessoaLog;
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String proximo = "login.jsp";
		
		
		
			
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Usuario user = new Usuario();
			user.setLogin(usuario);
			user.setSenha(senha);
			
			try {		
				Usuario us = usuarioDAO.consultarUsuario(user);
			if(us!=null) {
				if(us.getGpUs().equals("Cliente")) {
					proximo = "cliente/realizar-pedido.jsp";
				}else {
					request.setAttribute("msgErro", "Erro ao acessar esta tela!");
				}
				pessoaLog = pessoaDAO.getPessoa(user.getId());
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				session.setAttribute("pessoa", pessoaLog);
				session.setMaxInactiveInterval(60);
				 
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return proximo;
		
	}
	
	
	

}
