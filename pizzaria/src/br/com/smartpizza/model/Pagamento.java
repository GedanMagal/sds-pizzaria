package br.com.smartpizza.model;

public class Pagamento {
	private int idPagamento;
	private String dsPagamento;
	private double vlPagamento;
	private double troco;
	
	public Pagamento() {
		
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getDsPagamento() {
		return dsPagamento;
	}

	public void setDsPagamento(String dsPagamento) {
		this.dsPagamento = dsPagamento;
	}

	public double getVlPagamento() {
		return vlPagamento;
	}

	public void setVlPagamento(double vlPagamento) {
		this.vlPagamento = vlPagamento;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	public Pagamento(int idPagamento, String dsPagamento, double vlPagamento, double troco) {
		super();
		this.idPagamento = idPagamento;
		this.dsPagamento = dsPagamento;
		this.vlPagamento = vlPagamento;
		this.troco = troco;
	}

	
}
