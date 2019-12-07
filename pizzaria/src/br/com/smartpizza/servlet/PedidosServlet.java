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

import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dto.PedidoDTO;
import br.com.smartpizza.dto.PessoaDTO;
@WebServlet(urlPatterns = {"/admin/pedidos", "/pedidos"})
public class PedidosServlet extends HttpServlet {
	private PedidoDAO pedidoDAO;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pedidoDAO = new PedidoDAO();
		JsonObject jsonObject = new JsonObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		PrintWriter out = response.getWriter();
		String resp="";
		switch (acao) {
		case "listar":
			List<PedidoDTO> pedidos = pedidoDAO.listaPedidos();
			 resp = new Gson().toJson(pedidos);
			out.print(resp);
			break;
		case "filtar":
			String codigo = request.getParameter("codPedido");

			String dataIni = request.getParameter("dataInicio");

			String dataFim = request.getParameter("dataFim");
			
			List<PedidoDTO> filtro = pedidoDAO.listaPedidos();
			resp = new Gson().toJson(filtro);
			out.print(resp);
			break;
		default:
			break;
		}
		
		
	}
	
	
}
