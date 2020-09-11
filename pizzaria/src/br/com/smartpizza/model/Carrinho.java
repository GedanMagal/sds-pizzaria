package br.com.smartpizza.model;

import org.springframework.web.context.annotation.SessionScope;
@SessionScope
public class Carrinho {
	private Long item;
	private Long idProduto;
	private String nomeProduto;
	private Tamanho tamanho;
	private Long quantidade;
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	private float valorProduto;
	private float total;
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	public float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProdutp(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Carrinho() {
		// TODO Auto-generated constructor stub
	}
	
	
}
