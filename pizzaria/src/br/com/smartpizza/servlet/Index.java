package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
@WebServlet(urlPatterns = "/index")
public class Index extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO pdao = new ProdutoDAO();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObject = new JsonObject();
		PrintWriter out = response.getWriter();
		List<ProdutoDTO> produto = new ProdutoDAO().listarProdutospizza(1);
	
		String resp = new Gson().toJson(produto);
		
		out.print(resp);
		System.out.println(resp);
		System.out.println("ok");
	}
}
