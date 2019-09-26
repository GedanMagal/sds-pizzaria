package br.com.smartpizza.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class Funcionario extends Pessoa {

	private Calendar dataAdmissao;
	private int status;
	private String email;
	private String senha;

	private Cargo cargo;
	 


	public Funcionario(int id, String nome, String sobrenome, String cpf, String telefone, String celular,
			List<Endereco> endereco, Usuario usuario, Calendar dataAdmissao, int status, String email, String senha,
			Cargo cargo) {
		super(id, nome, sobrenome, cpf, telefone, celular, endereco, usuario);
		this.dataAdmissao = dataAdmissao;
		this.status = status;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
