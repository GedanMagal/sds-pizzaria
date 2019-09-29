package br.com.smartsds.bo;

import br.com.smartpizza.model.Pessoa;

public class PessoaBO {

	
	public void validarPessoa(Pessoa pessoa) throws Exception {
		if (pessoa.getNome()==null|| pessoa.getNome().equals("")) {
			throw new Exception("O nome deve ser Preenchido!");
		}
	}
}
