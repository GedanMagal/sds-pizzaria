package br.com.smartpizza.model;

import java.util.List;

public class Cliente {

	private Integer clienteId;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private Telefone telefone;
	private Usuario usuario;
	private List<Endereco> endereco;
	

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Cliente() {
	}

	public long getId() {
		return clienteId;
	}

	public void setId(Integer id) {
		
		this.clienteId = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Cliente(String email, String senha, Usuario usario, int id, String nome, String sobrenome) {
		this.email = email;
		this.senha = senha;
		this.usuario = usario;
		this.clienteId = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
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
		return usuario;
	}

	public void setUsario(Usuario usario) {
		this.usuario = usario;
	}

}