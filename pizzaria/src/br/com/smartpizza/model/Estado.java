package br.com.smartpizza.model;

public class Estado {
	private int idEstado;
	private String dsuf;
	private String dsSigla;
	
	public Estado() {
	
	}
	
	public Estado(int idEstado, String dsuf, String dsSigla) {
		super();
		this.idEstado = idEstado;
		this.dsuf = dsuf;
		this.dsSigla = dsSigla;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getDsuf() {
		return dsuf;
	}
	public void setDsuf(String dsuf) {
		this.dsuf = dsuf;
	}
	public String getDsSigla() {
		return dsSigla;
	}
	public void setDsSigla(String dsSigla) {
		this.dsSigla = dsSigla;
	}
	
	
}
