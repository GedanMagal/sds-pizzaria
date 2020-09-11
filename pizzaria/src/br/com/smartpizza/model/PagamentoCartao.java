package br.com.smartpizza.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(PagamentoCartao.TYPE_PAYMENT)
public class PagamentoCartao extends Pagamento{
	
	public static final String TYPE_PAYMENT = "cartao";

	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	

	
}
