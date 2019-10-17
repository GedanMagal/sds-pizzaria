package br.com.smartpizza.model;

import java.math.BigDecimal;

public class Pedido {
	private long idPedido;
	private String dataPedido;
	private BigDecimal valorPedido;
	private BigDecimal valorTroco;
	private Pagamento pagamento;
	private ItemPedido itemPadido;
	private Cliente cliente;
	private Funcionario funcionario;
	public Pedido() {}
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	public BigDecimal getValorTroco() {
		return valorTroco;
	}
	public void setValorTroco(BigDecimal valorTroco) {
		this.valorTroco = valorTroco;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public ItemPedido getItemPadido() {
		return itemPadido;
	}
	public void setItemPadido(ItemPedido itemPadido) {
		this.itemPadido = itemPadido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
