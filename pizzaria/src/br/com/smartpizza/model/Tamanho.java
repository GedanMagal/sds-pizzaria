package br.com.smartpizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tamanho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTamanho;
	private String dsTamanho;
	@OneToMany(mappedBy = "tamanho")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Tamanho() {
	}

	public int getIdTamanho() {
		return idTamanho;
	}

	public void setIdTamanho(int idTamanho) {
		this.idTamanho = idTamanho;
	}

	public String getDsTamanho() {
		return dsTamanho;
	}

	public void setDsTamanho(String dsTamanho) {
		this.dsTamanho = dsTamanho;
	}

	public Tamanho(int idTamanho, String dsTamanho) {
		super();
		this.idTamanho = idTamanho;
		this.dsTamanho = dsTamanho;
	}
	
	
}
