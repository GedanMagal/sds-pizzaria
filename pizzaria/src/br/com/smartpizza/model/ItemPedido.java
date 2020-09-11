package br.com.smartpizza.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ItemPedido {
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	private int quantidade;
	private Double desconto;
	private double total;
	private Long idProduto;
	private Long idPedido;
	
	
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}


	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ItemPedido() {	
		desconto = 0.0;
	}


	public ItemPedidoPK getId() {
		return id;
	}
	public void setId(ItemPedidoPK id) {
		this.id = id;
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
}
