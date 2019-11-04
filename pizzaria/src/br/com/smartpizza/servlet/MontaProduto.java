package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.command.Command;
import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;
@WebServlet(urlPatterns = {"/admin/montapizza", "/montapizza"})
public class MontaProduto extends HttpServlet{
	private String proximo;
	
	private ProdutoDAO produtoDAO;
	private SaborDAO saborDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item =0;
	double subtotal= 0.0;                                                     
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.saborDAO = new SaborDAO();
		this.produtoDAO = new ProdutoDAO();

		proximo = "realizar-pedido.jsp";
		String acao =	request.getParameter("acao");
	
		String tamanho = request.getParameter("tamanho");
		String sabor = request.getParameter("quantidadeSabores");
		String sab = request.getParameter("sabor");
	
		String sab2 = request.getParameter("sabo2");
		int idproduto  = Integer.parseInt(request.getParameter("idproduto"));
		
		ProdutoDTO p = produtoDAO.getProduto(idproduto);
		switch (acao) {
		case "adicionarcarrinho":

			
			item  = item+1;
			
			Carrinho carrinho = new Carrinho();
			carrinho.setItem(item);
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTamanho(p.getTamanho());
			carrinho.setValorProduto(p.getValorProduto());
			listaCarrinho.add(carrinho);
			System.out.println(item);
			request.setAttribute("itens", listaCarrinho);
			proximo = "admin?acao=realizarPedido";
			subtotal = subtotal+p.getValorProduto();
			System.out.println(subtotal);
			break;
		case "finalizar":
			ItemPedido pedido = new  ItemPedido();
			pedido.setQuantidade(item);
			Produto prod = new Produto();
			pedido.setProdutos(prod);
			prod.setIdProduto(p.getIdProduto());
			pedido.setDesconto(0.0);
			pedido.setTotal(subtotal);
			ItemPedidoDAO ipd = new ItemPedidoDAO();
			ipd.cadastrarItemPedido(pedido);
		default:
			break;
		}
		
		request.getRequestDispatcher(proximo).forward(request, response);
	}


}
