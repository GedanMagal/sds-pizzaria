package br.com.smartpizza.model;



public class Cidade {
	
	private int idCidade;
	private String nomeCidade;

	private Estado estado;
	
	public Cidade(int idCidade, String nomeCidade, Estado estado) {
		super();
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}
	public Cidade() {
	// TODO Auto-generated constructor stub
	}
	public long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
