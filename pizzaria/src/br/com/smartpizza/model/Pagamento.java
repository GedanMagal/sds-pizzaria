package br.com.smartpizza.model;

import java.util.Date;
public class Pagamento {
	
	
	private Integer id;	
	
	private Double vlPagamento;
	
	private Date dataHoraPagamento;
	
	private FormaPagamento formaPagamento;
	
	private double troco;
	
	

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getVlPagamento() {
		return vlPagamento;
	}
	
	public void setVlPagamento(Double vlPagamento) {
		this.vlPagamento = vlPagamento;
	}
	
	
	public Date getDataHoraPagamento() {
		return dataHoraPagamento;
	}

	public void setDataHoraPagamento(Date dataHoraPagamento) {
		this.dataHoraPagamento = dataHoraPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	
}
