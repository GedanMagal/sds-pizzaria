package br.com.smartpizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	private String dsLogradouro;
	private String numEndereco;
	private String cep;
	private String bairro;
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getDsLogradouro() {
		return dsLogradouro;
	}
	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}
	public String getNumEndereco() {
		return numEndereco;
	}
	public void setNumEndereco(String numEndereco) {
		this.numEndereco = numEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
