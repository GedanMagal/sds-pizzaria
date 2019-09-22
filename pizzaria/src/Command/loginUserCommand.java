package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.model.Usuario;

public class loginUserCommand implements Command{
	

	private UsuarioDAO userDAO;
	private PessoaDAO pessoaDAO;
	private PessoaDTO  pessoaLog;
	
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		userDAO = new UsuarioDAO();
		pessoaDAO = new PessoaDAO();
		
		String proximo = "index.jsp";
		
		
			
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			Usuario user = new Usuario();
			user.setLogin(usuario);
			user.setSenha(senha);
			System.out.println("ok aqui");
			try {		
			if(userDAO.consultarUsuario(user)) {
				pessoaLog = pessoaDAO.getPessoa(user.getId());
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				session.setAttribute("pessoa", pessoaLog);
				session.setMaxInactiveInterval(60);
				 proximo = "home-admin.jsp";
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return proximo;
		
		
	}

}
