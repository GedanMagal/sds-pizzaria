package br.com.smartpizza.dao;

public class Telefone {
	
	private long idTelefone;
	private String telefone;
	private String classificador;
	
	private Cliente idCliente;
	
	
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}

	public long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getClassificador() {
		return classificador;
	}

	public void setClassificador(String classificador) {
		this.classificador = classificador;
	}
	
}
