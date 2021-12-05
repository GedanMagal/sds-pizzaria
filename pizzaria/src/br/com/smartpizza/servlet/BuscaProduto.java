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
import com.google.gson.JsonObject;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
@WebServlet(urlPatterns = {"/admin/busca","/busca"})
public class BuscaProduto extends HttpServlet
{
	private ProdutoDAO pdao = new ProdutoDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jsonObject = new JsonObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "listar":
			List<ProdutoDTO> produtos = pdao.listarProdutospizza(1);
			
			String resp = new Gson().toJson(produtos);
			out.print(resp);
			break;
		case "listarBroto":
			List<ProdutoDTO> broto = pdao.listarProdutoPizzaBroto("pizza",1,"broto");
			
			String retorno = new Gson().toJson(broto);
			out.print(retorno);
			break;
		case "busca":
		
		String nome = request.getParameter("nome");
		
		List<ProdutoDTO> p = pdao.getProdutoByName(nome);
		
		String lista = new Gson().toJson(p);
		out.print(lista);
		}
		
		
	}
}
