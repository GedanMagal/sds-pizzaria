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

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dto.PessoaDTO;

@WebServlet(urlPatterns = {"/buscacliente", "/admin/buscacliente"})
public class PessoaServlet extends HttpServlet{
	private PessoaDAO pessoaDAO;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pessoaDAO = new PessoaDAO();
		JsonObject jsonObject = new JsonObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		
		List<PessoaDTO> pessoas = pessoaDAO.getClientes(nome);
		String resp = new Gson().toJson(pessoas);
		out.print(resp);
	}
	
}
