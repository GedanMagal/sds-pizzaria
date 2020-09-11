package br.com.smartpizza.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(Cliente.TYPE_PERSON)
public class Cliente extends Pessoa {
 
	public static final String TYPE_PERSON = "cliente";
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


}