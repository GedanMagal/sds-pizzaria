package br.com.smartpizza.model;

public class Cliente extends Pessoa { 
	

	private String email;
	private String senha;
	private Usuario usario;
	
	public Cliente() {}
	
	
	public Cliente(int id, String nome, String sobrenomne, String cpf, String email, String senha, Usuario usario) {
		super();
		
	
		this.email = email;
		this.senha = senha;
		this.usario = usario;
	}




	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario getUsario() {
		return usario;
	}
	public void setUsario(Usuario usario) {
		this.usario = usario;
	}

}
