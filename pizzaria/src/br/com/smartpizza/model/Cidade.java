package br.com.smartpizza.model;

import java.util.List;

public class Cidade {
	private int idCidade;
	private String cidade;
	private Estado estado;
	private List<Endereco> endereco;

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Cidade(int idCidade, String cidade, Estado estado, List<Endereco> endereco) {
		super();
		this.idCidade = idCidade;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
	}

	public Cidade() {
		// TODO Auto-generated constructor stub
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
}