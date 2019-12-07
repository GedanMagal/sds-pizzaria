package br.com.smartpizza.dto;

import java.util.Date;

public class PedidoDTO {
	private int idPedido;
	private Date dataPedido;
	private Double valorPedido;
	private String nomeCliente;
	private String sobrenome;
	private String tipoPagamento;
	private Double valorPagemnto;
	private Double vlTroco;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public Double getValorPagemnto() {
		return valorPagemnto;
	}
	public void setValorPagemnto(Double valorPagemnto) {
		this.valorPagemnto = valorPagemnto;
	}
	public Double getVlTroco() {
		return vlTroco;
	}
	public void setVlTroco(Double vlTroco) {
		this.vlTroco = vlTroco;
	}
	public PedidoDTO() {
	
	}
	public PedidoDTO(int idPedido, Date dataPedido, Double valorPedido, String nomeCliente, String sobrenome,
			String tipoPagamento, Double valorPagemnto, Double vlTroco) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
		this.nomeCliente = nomeCliente;
		this.sobrenome = sobrenome;
		this.tipoPagamento = tipoPagamento;
		this.valorPagemnto = valorPagemnto;
		this.vlTroco = vlTroco;
	}
	
	
	

}
