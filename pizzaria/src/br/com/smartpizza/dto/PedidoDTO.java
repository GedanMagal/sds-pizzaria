package br.com.smartpizza.dto;

public class PedidoDTO {

	private String nomeClient;
	private String pedidoNome;
	private String sabor;
	private String codigo;
	private String endereco;

	public PedidoDTO(String nomeClient, String pedidoNome, String sabor, String codigo) {
		this.nomeClient = nomeClient;
		this.pedidoNome = pedidoNome;
		this.sabor = sabor;
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeClient() {
		return nomeClient;
	}

	public void setNomeClient(String nomeClient) {
		this.nomeClient = nomeClient;
	}

	public String getPedidoNome() {
		return pedidoNome;
	}

	public void setPedidoNome(String pedidoNome) {
		this.pedidoNome = pedidoNome;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
