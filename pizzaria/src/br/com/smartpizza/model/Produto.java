package br.com.smartpizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	private String nomeProduto;
	@ManyToOne
	@JoinColumn(name = "tamanho_id")
	private Tamanho tamanho;
	private Double valor;
	@ManyToOne
	@JoinColumn(name = "tipo_produto_id")
	private TipoProduto tipoProduto;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_INGREDIENTE",
			joinColumns = @JoinColumn(name="produto_id"),
			inverseJoinColumns = @JoinColumn(name="ingrediente_id"))
	private List<Ingrediente> ingredientes = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Estoque estoque;
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	



	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Ingrediente> getSabor() {
		return ingredientes;
	}

	public void setSabor(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Produto() {}

}
