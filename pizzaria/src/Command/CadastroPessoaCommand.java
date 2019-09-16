package Command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.model.Cidade;
import br.com.smartpizza.model.Cliente;
import br.com.smartpizza.model.Endereco;
import br.com.smartpizza.model.Estado;
import br.com.smartpizza.model.Pessoa;

import br.com.smartpizza.model.Usuario;

public class CadastroPessoaCommand implements Command {
	private PessoaDAO dao = new PessoaDAO();
	private EstadoDAO  estadoDAO = new EstadoDAO();

	@Override
	public String execute(HttpServletRequest request) {
		
		
		List<Estado> listaEstados = estadoDAO.listarEstados();
		request.setAttribute("estados", listaEstados);
			
		return "";
	
	}
}
