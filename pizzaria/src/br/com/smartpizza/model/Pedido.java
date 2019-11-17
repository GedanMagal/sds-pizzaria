package br.com.smartpizza.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Pedido {
	private long idPedido;
	private String dataPedido;
	private double valorPedido;
	private double valorTroco;
	private Pagamento pagamento;
	private int idcliente;
	private int funcionario;
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
