package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Pagamento;
import br.com.smartpizza.model.Pedido;
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
	float subtotal= 0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pedidoDAO = new PedidoDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		int quantidade=0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject jsonObject = new JsonObject();
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		Usuario user = (Usuario) request.getSession().getAttribute("loginUser");

		HttpSession session = request.getSession();
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
			ProdutoDTO p = produtoDAO.getProdutoById(Integer.parseInt(idProduto));
			carrinho.setItem(item);
			carrinho.setIdProdutp(Integer.parseInt(idProduto));
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTamanho(p.getTamanho());
			carrinho.setTotal(subtotal+=p.getValorProduto());
			carrinho.setQuantidade(quantidade);
			listaCarrinho.add(carrinho);
			
			
			
			for (int i=0;i<listaCarrinho.size();i++) {
				totalpagar +=listaCarrinho.get(i).getTotal();
				
			}
			quantidade++;
			request.setAttribute("carrinho", listaCarrinho);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("quantidade", listaCarrinho.size());
			jsonObject.addProperty("quantidade", listaCarrinho.size());
			session.setAttribute("carrinho", listaCarrinho);
			out.print(jsonObject.toString());
			//request.getRequestDispatcher(proximo).forward(request, response);
			break;
		case "carrinho":
			totalpagar = 0.0;
			proximo = "carrinho.jsp";
			
			request.setAttribute("carrinho", listaCarrinho);	
			request.setAttribute("quantidade", listaCarrinho.size());
				for (int i=0;i<listaCarrinho.size();i++) {
					totalpagar =listaCarrinho.get(i).getTotal();
				
				}
				Cookie qtd = new Cookie("quantidade", listaCarrinho.size()+"");
				Cookie total = new Cookie("total", totalpagar+"");
				qtd.setMaxAge(2*60);
				total.setMaxAge(2*60);
				response.addCookie(qtd);
				response.addCookie(total);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("quantidade", listaCarrinho.size());
			
			
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
				request.setAttribute("carrinho", listaCarrinho);
				request.setAttribute("totalpagar", totalpagar);
				request.setAttribute("quantidade", listaCarrinho.size());
				
			}
			
			request.setAttribute("carrinho", listaCarrinho);	
			request.setAttribute("quantidade", listaCarrinho.size());
				for (int i=0;i<listaCarrinho.size();i++) {
					totalpagar =listaCarrinho.get(i).getTotal();
				}
				request.setAttribute("totalpagar", totalpagar);
				request.getRequestDispatcher(proximo).forward(request, response);
			break;
		case "gerarpedido":
			try {
			String  pessoa = request.getParameter("idcliente");
			
			String troco = request.getParameter("troco");
			String valorPagamento = request.getParameter("valorPagamento");
			String tamanho = request.getParameter("tamanho");
			String cartao = request.getParameter("cartao");
			Pedido pedido = new Pedido();
			
			Pagamento pagamento =  new Pagamento();
			pagamento.setVlPagamento(Double.parseDouble(valorPagamento));
			pagamento.setTroco(pagamento.getVlPagamento() - pedido.getValorPedido());
			pedido.setPagamento(pagamento);
			if(cartao==null||cartao.equals("")) {
				pagamento.setDsPagamento("dinheiro");
				pagamento.setTroco(Double.parseDouble(troco)-pagamento.getVlPagamento());
			}else {
				pagamento.setDsPagamento(cartao);
			}
			String data = sdf.format(Calendar.getInstance().getTime());
			pedido.setDataPedido(data);
			pedido.setValorPedido(subtotal);
			pedido.setValorTroco(pagamento.getTroco());
			pedido.setFuncionario(3);
			pedido.setIdcliente(Integer.parseInt(pessoa));
			pagamento.setVlPagamento(Double.parseDouble(valorPagamento));
			pagamento.setTroco(pagamento.getVlPagamento() - pedido.getValorPedido());
			request.setAttribute("carrinho", listaCarrinho);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("quantidade", listaCarrinho.size());
			 List<Carrinho> dados = (List<Carrinho>) session.getAttribute("carrinho");
			 int idpedido = pedidoDAO.cadastrarPedido(pedido);
			 int i=0;
			 List<ItemPedido> listaItens = new ArrayList<ItemPedido>();
			 for (Carrinho lc: dados) {
          		ProdutoDTO p2 = produtoDAO.getProdutoById(lc.getIdProduto());
          
          	ItemPedido ped = new ItemPedido();
			ped.setIdPedido(idpedido);
			ped.setQuantidade(item);
			ped.setIdProduto(p2.getIdProduto());
			listaItens.add(ped);
			ped.setTotal(pedido.getValorPedido()* ped.getQuantidade());
			ItemPedidoDAO idpd = new ItemPedidoDAO();
			i++;
			 
				idpd.cadastrarItemPedido(ped);
			 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			listaCarrinho.clear();
			break;
		
	
}
	}
}
