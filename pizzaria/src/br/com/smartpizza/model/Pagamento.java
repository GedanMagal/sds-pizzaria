package br.com.smartpizza.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pagamento_type", discriminatorType = DiscriminatorType.STRING)
public class Pagamento {
	public static final Integer PAGAMENTO_APROVADO = 1;
	public static final Integer PAGAMENTO_REPORVADO = 0;
	public static final Integer PAGAMENTO_AGUARDANDO = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPagamento;

	private Integer statusPagamnto;

	@OneToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Pagamento() {

	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Integer getStatusPagamnto() {
		return statusPagamnto;
	}

	public void setStatusPagamnto(Integer statusPagamnto) {
		this.statusPagamnto = statusPagamnto;
	}
	
	public String getStatusString() {
		if (statusPagamnto==1) {
			return "pagamento aprovado";
		}else if (statusPagamnto==2) {
			return "aguardnado pagamento";
		}else if (statusPagamnto ==0) {
			return "aguardnado reprovado";
		}
	return null;
	}

}
