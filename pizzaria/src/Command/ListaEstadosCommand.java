package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.EstadoDAO;
import br.com.smartpizza.model.Estado;

public class ListaEstadosCommand implements Command {
	private EstadoDAO estadoDAO = new EstadoDAO();
	@Override
	public String execute(HttpServletRequest request) {
		int idEstado  =  Integer.parseInt(request.getParameter("idCidade"));
		String proxima="";
		List<Estado> listEstados = estadoDAO.listarEstados();
		if(listEstados!=null) {
			StringBuilder dados = new StringBuilder();
			for(Estado sb : listEstados) {
				dados.append(sb.getIdEstado() + sb.getDsSigla());
			}
			proxima = "cadastroCliente";
			request.setAttribute("estados", listEstados);
		}
		
		return proxima;
	}

}
