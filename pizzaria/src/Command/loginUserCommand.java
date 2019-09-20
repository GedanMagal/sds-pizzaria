package Command;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.model.Usuario;

public class loginUserCommand implements Command{
	
	Usuario user = new Usuario();
	UsuarioDAO userDAO = new UsuarioDAO();
	
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String proximo = "index.jsp";
		
		try {			
			
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			user.setLogin(usuario);
			user.setSenha(senha);
			
			boolean isValid = userDAO.consultarUsuario(user);
			
			if(isValid) {
				
				request.getSession().setAttribute("loginUser", user);
				
				if(user.getGpUs().equals("Admin") || user.getGpUs().equals("Funcionario")) {
					proximo = "home-admin.jsp";
				} else if (user.getGpUs().equals("Cliente")) {
					proximo = "Client/meusPedidos.jsp";
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return proximo;
		
		
	}

}
