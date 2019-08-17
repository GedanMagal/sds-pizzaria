package br.com.smartpizza.dao;



public class Estado {
	
	private int idEstado;
	private String estado;
	private String sigla;
	
	
	public Estado(int idEstado, String estado, String sigla) {
		super();
		this.idEstado = idEstado;
		this.estado = estado;
		this.sigla = sigla;
	}
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
