package br.com.smartpizza.model;

import java.util.List;

public class Produto {
	
	private int idProduto;
	private String nomeProduto;
	private String tamanho;
	private float valor;
	private List<Sabor> sabor;
	private Estoque estoque;
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	private TipoProduto tipoProduto;

	

	

	public Produto(int idProduto, String nomeProduto, String tamanho, float valor, List<Sabor> sabor, Estoque estoque,
			TipoProduto tipoProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.tamanho = tamanho;
		this.valor = valor;
		this.sabor = sabor;
		this.estoque = estoque;
		this.tipoProduto = tipoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Sabor> getSabor() {
		return sabor;
	}

	public void setSabor(List<Sabor> sabor) {
		this.sabor = sabor;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Produto() {}

}
