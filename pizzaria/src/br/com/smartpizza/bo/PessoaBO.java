package br.com.smartpizza.bo;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Pessoa;

public class PessoaBO {
	private PessoaDAO dao = new PessoaDAO();
	
	public boolean validarPessoa(Pessoa pessoa) throws Exception {
		boolean isValid;
		if (pessoa.getNome()==null|| pessoa.getNome().equals("")) {
			throw new Exception("O nome deve ser Preenchido!");
		}else if(pessoa.getCpf()==null||"".contentEquals(pessoa.getCpf())) {
			throw new Exception("O cpf deve ser Preenchido!");
		}else if(pessoa.getSobrenome()==null||"".equals(pessoa.getSobrenome())) {
			throw new Exception("O spbreNome deve ser Preenchido!");
		}else {
			isValid = true;
		}
		return isValid;
	}
	
	public void cadastrarPessoa(Cliente cliente) throws Exception {
		try {
			dao.cadastroPessoaClient(cliente);
		}catch(Exception e) {
			e.printStackTrace();
			throw new   Exception();
		}
	}
}
