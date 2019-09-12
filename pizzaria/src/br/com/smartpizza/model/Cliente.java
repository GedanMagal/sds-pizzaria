package br.com.smartpizza.model;

import java.util.List;

public class Cliente extends Pessoa {
 

	private String email;
	private String senha;
	private List<Telefone> telefone;

	
	public Cliente(String email, String senha, List<Telefone> telefone, Usuario usuario) {
		super();
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		
	}
	public Cliente() {
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
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}





}