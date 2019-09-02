package br.com.smartpizza.model;

public class GrupoPermissao {
	private int idGrupoPermissao;
	private String nomeGrupo;
	
	
	
	public GrupoPermissao(int idGrupoPermissao, String nomeGrupo) {
		super();
		this.idGrupoPermissao = idGrupoPermissao;
		this.nomeGrupo = nomeGrupo;
	}
	public GrupoPermissao() {
	
	}
	public int getIdGrupoPermissao() {
		return idGrupoPermissao;
	}
	public void setIdGrupoPermissao(int idGrupoPermissao) {
		this.idGrupoPermissao = idGrupoPermissao;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

}
