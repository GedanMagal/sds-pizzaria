package br.com.smartpizza.model;

public class Telefone {
	
	private long idTelefone;
	private String telefone;
	private String classificador;
	
	private ClienteDAO idCliente;
	
	
	public void setIdCliente(ClienteDAO idCliente) {
		this.idCliente = idCliente;
	}
	public ClienteDAO getIdCliente() {
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
