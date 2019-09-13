package br.com.smartpizza.model;

import java.util.List;

public class Cliente extends Pessoa {
 

	private String email;
	private String senha;


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




	public Cliente(int id, String nome, String sobrenome, String cpf, String email, String senha,
			List<Endereco> endereco, Usuario usuario, String email2, String senha2) {
		super(id, nome, sobrenome, cpf, email, senha, endereco, usuario);
		email = email2;
		senha = senha2;
	}






}