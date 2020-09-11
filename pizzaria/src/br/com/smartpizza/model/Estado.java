package br.com.smartpizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstado;
	private String dsuf;
	private String dsSigla;
	
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<>();
	public Estado() {
	
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public String getDsuf() {
		return dsuf;
	}
	public void setDsuf(String dsuf) {
		this.dsuf = dsuf;
	}
	public String getDsSigla() {
		return dsSigla;
	}
	public void setDsSigla(String dsSigla) {
		this.dsSigla = dsSigla;
	}
	
	
}
