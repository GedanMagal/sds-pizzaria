package br.com.smartpizza.model;

public class Estoque {
	private int idEstoque;
	private int qtdEstoque;
	
	public Estoque() {}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Estoque(int idEstoque, int qtdEstoque) {
		super();
		this.idEstoque = idEstoque;
		this.qtdEstoque = qtdEstoque;
	}
	
	
}
