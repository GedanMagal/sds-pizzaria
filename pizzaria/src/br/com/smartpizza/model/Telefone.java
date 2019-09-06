package br.com.smartpizza.model;

public class Telefone {
	private int idTelefone;
	private String telefone;
	private String classificador;
	private Cliente cliente;

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}