package br.com.smartpizza.dao;

public class IngredientaDAO {
		
	
		private int idIngrediente;
		private String dsIngrediente;
		private boolean isRequerido;
		private float valor;
		
		public IngredientaDAO() {}

		public IngredientaDAO(int idIngrediente, String dsIngrediente, boolean isRequerido, float valor) {
			super();
			this.idIngrediente = idIngrediente;
			this.dsIngrediente = dsIngrediente;
			this.isRequerido = isRequerido;
			this.valor = valor;
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

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}
		
		
		
}
