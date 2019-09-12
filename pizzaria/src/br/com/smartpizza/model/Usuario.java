package br.com.smartpizza.model;

public class Usuario {
		private int id;
		private String login;
		private String senha;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public Usuario(int id, String login, String senha) {
			super();
			this.id = id;
			this.login = login;
			this.senha = senha;
		}
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
	}
