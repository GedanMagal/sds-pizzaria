package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Usuario;
@WebServlet(urlPatterns = "/index")
public class Index extends HttpServlet {
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;
	private PessoaDAO pessoaDAO;
	String proximo ="";
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item=0;
	Carrinho carrinho = new Carrinho();
	double totalpagar;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pedidoDAO = new PedidoDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		int quantidade=0;
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObject = new JsonObject();
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		Usuario user = (Usuario) request.getSession().getAttribute("loginUser");

		
		switch(acao) {
		
		case "listar":
			
			List<ProdutoDTO> produto = new ProdutoDAO().listarProdutospizza(1);
			String resp = new Gson().toJson(produto);
			out.print(resp);
		break;
		
		case "add":
			
			quantidade++;
			proximo = "index.jsp";
			item = item + 1;
			String idProduto = request.getParameter("idproduto");
			ProdutoDTO p = produtoDAO.getProduto(Integer.parseInt(idProduto));
			carrinho.setItem(item);
			carrinho.setIdProdutp(Integer.parseInt(idProduto));
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTamanho(p.getTamanho());
			carrinho.setTotal(p.getValorProduto());
			carrinho.setQuantidade(quantidade);
			listaCarrinho.add(carrinho);
			for (int i=0;i<listaCarrinho.size();i++) {
				totalpagar +=listaCarrinho.get(i).getTotal();
			}
			quantidade++;
			request.setAttribute("carrinho", listaCarrinho);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("quantidade", listaCarrinho.size());
			
			
			request.getRequestDispatcher(proximo).forward(request, response);
			break;
		case "carrinho":
			totalpagar = 0.0;
			proximo = "carrinho.jsp";
			
			request.setAttribute("carrinho", listaCarrinho);	
			request.setAttribute("quantidade", listaCarrinho.size());
				for (int i=0;i<listaCarrinho.size();i++) {
					totalpagar +=listaCarrinho.get(i).getTotal();
				}
				Cookie qtd = new Cookie("quantidade", listaCarrinho.size()+"");
				Cookie total = new Cookie("total", totalpagar+"");
				qtd.setMaxAge(2*60);
				total.setMaxAge(2*60);
				response.addCookie(qtd);
				response.addCookie(total);
			request.setAttribute("totalpagar", totalpagar);
			request.getRequestDispatcher(proximo).forward(request, response);
			break;
		case "index":
			proximo = "index.jsp";
			request.setAttribute("quantidade", listaCarrinho.size());
			request.getRequestDispatcher(proximo).forward(request, response);
			
			break;
		case "finalizarpedido":
			
			if(user!=null) {
				
				proximo = "pagamento.jsp";
				String valor = "";
				Cookie cookies[] = request.getCookies();
				if(cookies!=null) {
					for (int i=0;i<cookies.length;i++) {
						if(cookies[i].getName().equals("total"))
						valor = cookies[i].getValue();
					}
				}
				request.setAttribute("totalPagar", valor);
			}else {
				proximo = "entrar.jsp";
				String carrion = new Gson().toJson(listaCarrinho);
				out.print(carrion);
				Cookie car = new Cookie("carrinho",carrion);
				
				
			}
			
			request.setAttribute("carrinho", listaCarrinho);	
			request.setAttribute("quantidade", listaCarrinho.size());
				for (int i=0;i<listaCarrinho.size();i++) {
					totalpagar +=listaCarrinho.get(i).getTotal();
				}
				request.setAttribute("totalpagar", totalpagar);
				request.getRequestDispatcher(proximo).forward(request, response);
			break;
		}
	
}
}
