package br.com.smartpizza.model;

import java.math.BigDecimal;
import java.util.List;

public class ItemPedido {
	private long idItemPedido;
	private int quantidade;
	private double total;
	private int idProduto;
	private long idPedido;
	
	

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ItemPedido(long idItemPedido, int quantidade, double total, int idProduto, int idPedido) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.total = total;
		this.idProduto = idProduto;
		this.idPedido = idPedido;
	}
	

}
