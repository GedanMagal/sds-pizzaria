package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.model.Estado;

public class ListaEstadosCommand implements Command {
	private EstadoDAO estadoDAO = new EstadoDAO();
	
	private String proxima;
	@Override
	public String execute(HttpServletRequest request) {
	
		proxima ="cadastroCliente.jsp";
		List<Estado> listEstados = estadoDAO.listarEstados();
		request.setAttribute("estados", listEstados);
		return proxima;
	}

}
