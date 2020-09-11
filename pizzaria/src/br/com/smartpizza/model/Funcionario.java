	package br.com.smartpizza.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(Funcionario.TYPE_PERSON)
public class Funcionario extends Pessoa {

	public static final String TYPE_PERSON = "funcionario";
	private String dataAdmissao;
	@OneToOne
	private Cargo cargo;
	 

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}
