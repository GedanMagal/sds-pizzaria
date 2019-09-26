package Command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.CargoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.model.Cargo;
import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Endereco;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.model.Funcionario;
import br.com.smartpizza.model.Usuario;

public class CadastrarFuncionarioCommand implements Command {

	private PessoaDAO dao = new PessoaDAO();
	private CargoDAO cargoDAO = new CargoDAO();

	@Override
	public String execute(HttpServletRequest request) {

		String proximo = "gerenciar-funcionario.jsp";

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
		// String referencia = request.getParameter("complemento");
		String numero = request.getParameter("numero");

		String dataAdmissao = request.getParameter("dataAdmissao");
		String status = request.getParameter("status");

		String nomeCargo = request.getParameter("nomeCargo");
		String descricao = request.getParameter("descricao");

		try {
			Funcionario f = new Funcionario();
			Cidade cid = new Cidade();
			Usuario usuar = new Usuario();
			Endereco endereco = new Endereco();
			Estado est = new Estado();
			Cargo cargo = new Cargo();
			f.setNome(nome);
			f.setSobrenome(sobreNome);
			f.setCpf(cpf);
			f.setEmail(email);
			f.setSenha(senha);
			f.setTelefone(telefone);
			f.setCelular(celular);
			SimpleDateFormat sdf = new SimpleDateFormat();
			f.setDataAdmissao(Calendar.getInstance());
			f.setStatus(Integer.parseInt(status));

			f.setCargo(cargo);
			cargo.setNomeCargo(nomeCargo);
			cargo.setDescricao(descricao);

			f.setUsuario(usuar);
			usuar.setLogin(email);
			usuar.setSenha(senha);
			System.out.println(idEstado);
			List<Endereco> listEndereco = new ArrayList<Endereco>();

			for (String end : logradouro) {

				endereco.setDsLogradouro(end);
				endereco.setNumEndereco(numero);
				endereco.setCep(cep);
				endereco.setBairro(bairro);

				endereco.setCidade(cid);
				cid.setIdCidade(Integer.parseInt(cidade));

				cid.setEstado(est);
				est.setIdEstado(Integer.parseInt(idEstado));

				listEndereco.add(endereco);

			}
			f.setEndereco(listEndereco);

			int idCargo = cargoDAO.cadastroCargo(cargo);
			dao.cadastroFuncionario(f, idCargo);
			proximo = "index.jsp";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("ok servlet funciona");

		return proximo;
	}

}
