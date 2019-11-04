package br.com.smartpizza.model;

import java.math.BigDecimal;
import java.util.List;

public class ItemPedido {
	private long idItemPedido;
	private int quantidade;
	private double desconto; 
	private double total;
	private Produto produtos;
		
	
	public ItemPedido(long idItemPedido, int quantidade, double desconto, double total, Produto produtos) {
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.total = total;
		this.produtos = produtos;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public ItemPedido() {	}

	public long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

}
