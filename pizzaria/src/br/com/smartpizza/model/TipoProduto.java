package br.com.smartpizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoProduto;
	private String dsTipoProduto;
	@OneToMany(mappedBy = "tipoProduto")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Long getIdTipoProduto() {
		return idTipoProduto;
	}
	public void setIdTipoProduto(Long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}
	public String getDsTipoProduto() {
		return dsTipoProduto;
	}
	public void setDsTipoProduto(String dsTipoProduto) {
		this.dsTipoProduto = dsTipoProduto;
	}
	public TipoProduto() {
		// TODO Auto-generated constructor stub
	}


}
