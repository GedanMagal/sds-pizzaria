package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.model.Produto;
@WebServlet(urlPatterns = {"/admin/busca","/busca"})
public class BuscaProduto extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private  ProdutoDAOImpl dao;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "listar":
			List<Produto> produtos = dao.listAll();
			
			String resp = new Gson().toJson(produtos);
			out.print(resp);
			break;
		case "listarBroto":
			List<Produto> broto = dao.findBySizeAndType("pizza",1L);
			
			String retorno = new Gson().toJson(broto);
			out.print(retorno);
			break;
		case "busca":
		
		String name = request.getParameter("nome");
		
		List<Produto> p = dao.findByNames(name);
		
		String lista = new Gson().toJson(p);
		out.print(lista);
		}
		
		
	}
}
