package Command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Endereco;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.model.Pessoa;

import br.com.smartpizza.model.Usuario;

public class CadastroPessoaCommand implements Command {
	private PessoaDAO dao = new PessoaDAO();

	@Override
	public String execute(HttpServletRequest request) {
		String proximo = "cadastroCliente.jsp";

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String sobreNome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");
	
		String celular = request.getParameter("celular");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String referencia = request.getParameter("complemento");
		String numero = request.getParameter("numero");
	
		String[] enderecos = request.getParameterValues("endereco");

	

		
			

		
		try {
			Cliente p = new Cliente();
			p.setNome(nome);
			p.setSobrenome(sobreNome);
			p.setCpf(cpf);
			p.setEmail(email);
			p.setSenha(senha);
			p.setTelefone(telefone);
			p.setCelular(celular);
			Usuario usuar = new Usuario();
			p.setUsuario(usuar);

			usuar.setLogin(email);
			usuar.setSenha(senha);
			List<Endereco> listEndereco = new ArrayList<Endereco>();
			for (String end : enderecos) {
				Endereco endereco = new Endereco();
				endereco.setDsLogradouro(end);
				endereco.setNumEndereco(numero);
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				Cidade cid = new Cidade();
				endereco.setCidade(cid);
				cid.setCidade(cidade);
				Estado est = new Estado();
				cid.setEstado(est);
				est.setDsuf(estado);
				listEndereco.add(endereco);

			}
			p.setEndereco(listEndereco);
			

			dao.cadastroPessoaClient(p);
			proximo = "index.jsp";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ok servlet funciona");
		return proximo;
	}

}
