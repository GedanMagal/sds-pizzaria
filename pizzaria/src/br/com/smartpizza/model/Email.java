package br.com.smartpizza.model;

public class Email {
	private long idEmail;
	private String descEmail;
	
	public void setDescEmail(String descEmail) {
		this.descEmail = descEmail;
	}


	public String getDescEmail() {
		return descEmail;
	}
	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}
	public long getIdEmail() {
		return idEmail;
	}
}
