package br.com.smartpizza.model;

import java.util.List;

public class Sabor {
	private int idSabor;
	private String dsSabor;
	private List< Ingrediente> ingredientes;
	 
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public Sabor(int idSabor, String dsSabor, List<Ingrediente> ingredientes) {
		super();
		this.idSabor = idSabor;
		this.dsSabor = dsSabor;
		this.ingredientes = ingredientes;
	}
	public Sabor(int idSabor, String dsSabor) {
		super();
		this.idSabor = idSabor;
		this.dsSabor = dsSabor;
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
