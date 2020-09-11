package br.com.smartpizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstoque;
	private int qtdEstoque;
	
	public Estoque() {}

	public Long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}


	
}
