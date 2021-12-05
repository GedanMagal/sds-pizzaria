package br.com.smartpizza.model;

import java.util.List;

public class Sabor {
	private int idSabor;
	private String dsSabor;
	private double preco;
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	private List< Ingrediente> ingredientes;
	 
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Sabor(int idSabor, String dsSabor, double preco, List<Ingrediente> ingredientes) {
		super();
		this.idSabor = idSabor;
		this.dsSabor = dsSabor;
		this.preco = preco;
		this.ingredientes = ingredientes;
	}
	public Sabor() {}
	public int getIdSabor() {
		return idSabor;
	}
	public void setIdSabor(int idSabor) {
		this.idSabor = idSabor;
	}
	public String getDsSabor() {
		return dsSabor;
	}
	public void setDsSabor(String dsSabor) {
		this.dsSabor = dsSabor;
	}
	
	
}
