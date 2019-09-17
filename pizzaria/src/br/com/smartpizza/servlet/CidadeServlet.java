package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.smartpizza.dao.CidadeDAO;
import br.com.smartpizza.model.Cidade;
@WebServlet("/cidadeServlet")
public class CidadeServlet extends HttpServlet{

	private CidadeDAO cidadeDAO = new CidadeDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idEstado = Integer.parseInt(req.getParameter("idEstado"));
		
	 
		List<Cidade> listaCidade =  cidadeDAO.consultaCidades(idEstado);
		
			PrintWriter out = resp.getWriter();
			StringBuilder sb = new StringBuilder("");
		
		
		if(listaCidade!=null) {
			for(int i= 0;i<listaCidade.size();i++) {
				sb.append(listaCidade.get(i).getIdCidade()+ "-"+  listaCidade.get(i).getCidade()+":");
				System.out.println(listaCidade.get(i).getIdCidade()+ " - "+  listaCidade.get(i).getCidade());
				out.write(sb.toString());
			}
			
		}
		
	}
}
