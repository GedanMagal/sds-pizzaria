package br.com.smartpizza.model;

public class FormaPagamento {
	
	public final static String  PAGAMENTO_CARTAO = "cartao";
	public final static String  PAGAMENTO_DINHEiRO = "dinheiro";
	
	private Integer id;
	
	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
}
