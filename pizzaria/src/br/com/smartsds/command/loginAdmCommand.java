package br.com.smartsds.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Usuario;

public class loginAdmCommand implements Command{
	

	private UsuarioDAO userDAO;
	private PessoaDAO pessoaDAO;
	private PessoaDTO  pessoaLog;
	
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		userDAO = new UsuarioDAO();
		pessoaDAO = new PessoaDAO();
		
		String proximo = "login.jsp";
		
		
			
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Usuario user = new Usuario();
			user.setLogin(usuario);
			user.setSenha(senha);
			
			try {		
				Usuario us = userDAO.consultarUsuario(user);
			if(us!=null) {
				System.out.println(us.getGpUs());
				if(us.getGpUs().equals("Admin")) {
					proximo = "home-admin.jsp";
				}else {
					request.setAttribute("msgErro", "Erro ao acessar esta tela!");
				}
				pessoaLog = pessoaDAO.getPessoa(user.getId());
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				session.setAttribute("pessoa", pessoaLog);
				session.setMaxInactiveInterval(60*10);
				 
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return proximo;
		
		
	}

}
