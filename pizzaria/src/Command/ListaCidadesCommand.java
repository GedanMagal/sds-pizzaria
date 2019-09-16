package Command;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.com.smartpizza.dao.CidadeDAO;
import br.com.smartpizza.model.Cidade;

public class ListaCidadesCommand implements Command{
	private CidadeDAO cidadeDAO = new CidadeDAO();
	@Override
	public String execute(HttpServletRequest request) {
		int idEstado = Integer.parseInt(request.getParameter("estado"));
		String isEdit =request.getParameter("isEdit");
	 
		List<Cidade> listaCidade =  cidadeDAO.consultaCidades(idEstado);
			Gson json =  new Gson();
			StringBuilder sb = new StringBuilder();
		String cidade  =  json.toJson(listaCidade);
		
		if(listaCidade!=null) {
			for(Cidade cid : listaCidade) {
				sb.append(cid.getIdCidade() +"-"+ cid.getCidade());
			}
		}
		request.setAttribute("dados", sb);
		
		return null;
	}

}
