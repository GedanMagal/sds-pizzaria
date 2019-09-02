package br.com.smartpizza.model;

public class Cliente { 
	

	private int id;
	private String nome;
	private String sobrenomne;
	private String cpf;
	private String email;
	private String senha;
	private Usuario usario;
	
	public Cliente() {}
	
	
	public Cliente(int id, String nome, String sobrenomne, String cpf, String email, String senha, Usuario usario) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenomne = sobrenomne;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.usario = usario;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenomne() {
		return sobrenomne;
	}
	public void setSobrenomne(String sobrenomne) {
		this.sobrenomne = sobrenomne;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
