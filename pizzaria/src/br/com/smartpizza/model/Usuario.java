package br.com.smartpizza.model;
public class Usuario {
	private int id;

	private String login;
	private String senha;
	private GrupoPermissao permissao;

	public Usuario(int id, String login, String senha) {
		super();
		this.setId(id);
		this.login = login;
		this.senha = senha;
	}

	
	public String getLogin() {
		return login;
	}
	

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean ehIgual(String login, String senha) {
		if(!this.login.equals(login)) {
			return false;
		}
		
		if(!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}
}