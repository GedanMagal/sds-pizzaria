package br.com.smartpizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngrediente;
	private String dsIngrediente;
	private boolean isRequerido;
	private float valorIngrediente;
	
	public Ingrediente() {}

	

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
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
