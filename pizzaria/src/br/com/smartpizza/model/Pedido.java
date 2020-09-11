package br.com.smartpizza.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	private String dataPedido;
	private double valorPedido;
	private double valorTroco;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	private int idcliente;
	private int funcionario;
	@OneToMany(mappedBy = "id.pedido")	
	private Set<ItemPedido> itens = new HashSet<>();
	
	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	public Set<ItemPedido> getItens() {
		return itens;
	}
	
	public Pedido() {}
	
	
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	
	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}
	public double getValorPedido() {
		return valorPedido;
	}
	public double getValorTroco() {
		return valorTroco;
	}
	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	
}
