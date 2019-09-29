package br.com.smartpizza.model;

public class Cargo {

	private int idCargo;
	private String descricao;

	public Cargo() {
		// TODO Auto-generated constructor stub
	}

	public Cargo(int idCargo, String descricao) {
		super();
		this.idCargo = idCargo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	 
}
