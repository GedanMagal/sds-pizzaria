package br.com.smartpizza.model;

public class Ingrediente {

	private int idIngrediente;
	private String dsIngrediente;
	private boolean isRequerido;
	private float valorIngrediente;
	
	public Ingrediente() {}

	public Ingrediente(int idIngrediente, String dsIngrediente, boolean isRequerido, float valorIngrediente) {
		super();
		this.idIngrediente = idIngrediente;
		this.dsIngrediente = dsIngrediente;
		this.isRequerido = isRequerido;
		this.valorIngrediente = valorIngrediente;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getDsIngrediente() {
		return dsIngrediente;
	}

	public void setDsIngrediente(String dsIngrediente) {
		this.dsIngrediente = dsIngrediente;
	}

	public boolean isRequerido() {
		return isRequerido;
	}

	public void setRequerido(boolean isRequerido) {
		this.isRequerido = isRequerido;
	}

	public float getValorIngrediente() {
		return valorIngrediente;
	}

	public void setValorIngrediente(float valorIngrediente) {
		this.valorIngrediente = valorIngrediente;
	}
	
	
}
