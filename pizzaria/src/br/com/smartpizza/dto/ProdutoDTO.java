package br.com.smartpizza.dto;

public class ProdutoDTO {
	private Integer idProduto;
	private String nomeProduto;
	private String tamanho;
	private float valorProduto;
	private Integer quantidade;
	private String dsTipo;
	
	public ProdutoDTO() {
	
	}

	public ProdutoDTO(Integer idProduto, String nomeProduto, String tamanho, float valorProduto, Integer quantidade,
			String dsTipo) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.tamanho = tamanho;
		this.valorProduto = valorProduto;
		this.quantidade = quantidade;
		this.dsTipo = dsTipo;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDsTipo() {
		return dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}
	
}	
