	package br.com.smartpizza.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class Funcionario extends Pessoa {

	private String dataAdmissao;
	
	private Cargo cargo;
	 

	
	public Funcionario(int id, String nome, String sobrenome, String cpf, String telefone, String celular,
			List<Endereco> endereco, Usuario usuario, String dataAdmissao, int status, Cargo cargo) {
		super(id, nome, sobrenome, cpf, telefone, celular, endereco, usuario);
		this.dataAdmissao = dataAdmissao;
		
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

	

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}
