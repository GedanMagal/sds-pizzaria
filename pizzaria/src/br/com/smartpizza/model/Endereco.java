package br.com.smartpizza.model;

public class Endereco {
	

	private int idEndereco;
	private String dsLogradouro;
	private String numEndereco;
	private String cep;
	private String bairro;
	private Cidade cidade;
	
	public Endereco(int idEndereco, String dsLogradouro, String numEndereco, String cep, String bairro, Cidade cidade) {
		super();
		this.idEndereco = idEndereco;
		this.dsLogradouro = dsLogradouro;
		this.numEndereco = numEndereco;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
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
