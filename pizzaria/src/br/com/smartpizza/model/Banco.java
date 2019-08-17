package br.com.smartpizza.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	static {
		// Criar itens estaticos e futuramente, implementar o banco ao projeto
		Usuario u1 = new Usuario();
		u1.setLogin("gedan");
		u1.setSenha("online");
		
		Usuario u2 = new Usuario();
		u2.setLogin("gedan");
		u2.setSenha("online");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
	}
	
	
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
}
	
}
