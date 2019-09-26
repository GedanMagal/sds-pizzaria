package br.com.smartpizza.model;

public class TipoProduto {
	private int idTipoProduto;
	private String dsTipoProduto;

	public TipoProduto(int idTipoProduto, String dsTipoProduto) {

		this.idTipoProduto = idTipoProduto;
		this.dsTipoProduto = dsTipoProduto;
	}
	public int getIdTipoProduto() {
		return idTipoProduto;
	}
	public void setIdTipoProduto(int idTipoProduto) {
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
