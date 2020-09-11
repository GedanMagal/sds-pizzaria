package br.com.smartpizza.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(PagamentoBoleto.TYPE_PAYMENT)
public class PagamentoBoleto extends Pagamento{
	
	public static final String TYPE_PAYMENT = "boleto";

	private static final long serialVersionUID = 1L;

	
	private Date dataPagamento;

	
	private Date dataVencimento;
	
	public PagamentoBoleto() {
		// TODO Auto-generated constructor stub
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	
}
