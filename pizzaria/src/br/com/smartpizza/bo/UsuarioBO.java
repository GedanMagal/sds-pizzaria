package br.com.smartpizza.bo;

import br.com.smartpizza.dao.UsuarioDAO;
import br.com.smartpizza.model.Usuario;

public class UsuarioBO {
	private UsuarioDAO usuarioDAO;
	
	public Usuario validarUsuario(Usuario usuario) throws Exception {
		Usuario us = null;
		try {
			us = usuarioDAO.consultarUsuario(usuario);
		}catch(Exception e) {
			throw new Exception();
		}
		return us;
	}
}
