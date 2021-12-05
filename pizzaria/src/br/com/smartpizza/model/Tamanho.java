package br.com.smartpizza.model;

public class Tamanho {
	private int idTamanho;
	private String dsTamanho;
	
	public Tamanho() {
	}

	public int getIdTamanho() {
		return idTamanho;
	}

	public void setIdTamanho(int idTamanho) {
		this.idTamanho = idTamanho;
	}

	public String getDsTamanho() {
		return dsTamanho;
	}

	public void setDsTamanho(String dsTamanho) {
		this.dsTamanho = dsTamanho;
	}

	public Tamanho(int idTamanho, String dsTamanho) {
		super();
		this.idTamanho = idTamanho;
		this.dsTamanho = dsTamanho;
	}
	
	
}
