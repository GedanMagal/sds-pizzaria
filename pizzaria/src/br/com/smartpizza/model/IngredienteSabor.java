package br.com.smartpizza.model;

public class IngredienteSabor {
	private int idIngrediente;
	private int idSabor;
	
	public IngredienteSabor() {
		// TODO Auto-generated constructor stub
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdSabor() {
		return idSabor;
	}

	public void setIdSabor(int idSabor) {
		this.idSabor = idSabor;
	}

	public IngredienteSabor(int idIngrediente, int idSabor) {
		super();
		this.idIngrediente = idIngrediente;
		this.idSabor = idSabor;
	}
	
	
}
