package br.com.smartpizza.dto;

public class PessoaDTO {

	private int idPessoa;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private Integer idEndereco;
	private String endereco;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String gpUsuario;
	private String descricaoCargo; 
	private String dataAdmissao;
	
	public String getDataAdmissao() {
		return dataAdmissao;
	}


	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}


	public String getDescricaoCargo() {
		return descricaoCargo;
	}


	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}


	public String getGpUsuario() {
		return gpUsuario;
	}


	public void setGpUsuario(String gpUsuario) {
		this.gpUsuario = gpUsuario;
	}


	public Integer getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	
	public PessoaDTO() {
		
	}
	
	
	public PessoaDTO(int idPessoa, String nome, String sobrenome, String cpf, String telefone, String celular,
			String email, String endereco, String numero, String cep, String bairro, String cidade, String estado, Integer idEndereco) {
	
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.idEndereco = idEndereco;
	}


	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
