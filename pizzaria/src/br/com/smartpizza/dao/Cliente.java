package br.com.smartpizza.dao;

import java.util.List;


public class Cliente {
	
	private long idCliente;
	private String nome;
	private String cpf;
	private Email email;

	
	private List<Endereco> enderecos;
	
	private List<Telefone> telefones;
	





	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public Email getEmail() {
		return email;
	}
	
	
	
}
