package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.bo.PessoaBO;
import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Endereco;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.model.Usuario;

public class CadastrarClienteCommand implements Command {
	private PessoaBO pessoaBO = new PessoaBO();
	private PessoaDAOImpl pessoaDAO = new PessoaDAOImpl();
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String proximo = "admin?acao=listarClientes";

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String sobreNome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");
	
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
	
		String[] logradouro = request.getParameterValues("logradouro");
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String idEstado = request.getParameter("estado");
		String referencia = request.getParameter("complemento");
		String numero = request.getParameter("numero");
	
		

		try {
			Cliente p = new Cliente();
			Cidade cid = new Cidade();
			Usuario usuar = new Usuario();
			Endereco endereco = new Endereco();
			Estado est = new Estado();
			p.setNome(nome);
			p.setSobrenome(sobreNome);
			p.setCpf(cpf);
			p.setEmail(email);
			p.setSenha(senha);
			p.setTelefone(telefone);
			p.setCelular(celular);
			
			p.setUsuario(usuar);
			usuar.setLogin(email);
			usuar.setSenha(senha);
			usuar.setGpUs("Cliente");
			System.out.println(idEstado);
			List<Endereco> listEndereco = new ArrayList<Endereco>();
		
		for (String end: logradouro) {
			
			endereco.setDsLogradouro(end);
			endereco.setNumEndereco(numero);
			endereco.setCep(cep);
			endereco.setBairro(bairro);
			
			endereco.setCidade(cid);
			cid.setIdCidade(Long.parseLong(cidade));
			
			cid.setEstado(est);
			est.setIdEstado((long) Integer.parseInt(idEstado));
			
			listEndereco.add(endereco);
			
		}
		p.setEndereco(listEndereco);
		pessoaDAO.save(p);
		request.setAttribute("msgSucesso", "Cadastrado Com sucesso!");
	
			
		} catch (Exception e) {
			proximo = "adminis?acao=listaEstado&param=admin";
			request.setAttribute("msgErro", "Não foi possivel cadastrar!");
		}
	

		
		return proximo;
	}

}
