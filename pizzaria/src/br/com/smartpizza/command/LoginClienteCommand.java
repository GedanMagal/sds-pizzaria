package br.com.smartpizza.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Usuario;

public class LoginClienteCommand implements Command {
	private UsuarioDAO userDAO;
	private PessoaDAO pessoaDAO;
	private PessoaDTO pessoaLog;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.userDAO = new UsuarioDAO();
		this.pessoaLog = new PessoaDTO();
		this.pessoaDAO = new PessoaDAO();
		// TODO Auto-generated method stub
		String proximo = "entrar.jsp";
		HttpSession session = request.getSession();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario user = new Usuario();
		user.setLogin(usuario);
		user.setSenha(senha);
		
		try {
			Usuario us = userDAO.consultarUsuario(user);
			pessoaLog = pessoaDAO.getClienteUsuario(us.getId());
		
			String valor = "";
			Cookie cookies[] = request.getCookies();
			if(us.getGpUs().equals("Cliente")) {
				
			if(cookies!=null) {
				for (int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("total"))
					valor = cookies[i].getValue();
				}
			}
			
			
			request.setAttribute("totalPagar", valor);
			session.setAttribute("loginUser", us);
			session.setAttribute("id", pessoaLog);
		
			session.setMaxInactiveInterval(60*10);
			
			if(!valor.equals("")||valor.equals("0.0")) {
				proximo = "index?acao=finalizarpedido";
				
			}else {
				proximo = "/areadocliente/meus-pedidos.jsp";
			}
		}else {
			request.setAttribute("msgErro", "usuario sem permissão!");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proximo;

	}

}
