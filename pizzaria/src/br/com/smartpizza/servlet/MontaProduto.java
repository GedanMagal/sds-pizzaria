package br.com.smartpizza.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Usuario;

@WebServlet(urlPatterns = {"/admin/montapizza", "/montapizza"})
public class MontaProduto extends HttpServlet{
	private String proximo;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	private PessoaDAO pessoaDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item =0;
	double subtotal= 0.0;                                                     
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.pedidoDAO = new PedidoDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		proximo = "realizar-pedido.jsp";
		
		String acao =request.getParameter("acao");
	
		int idItemPedio= 0;
		Usuario id = (Usuario) request.getSession().getAttribute("loginUser");
		PessoaDTO pessoaid = pessoaDAO.getFuncionarioUsuario(id.getId());
		
		switch (acao) {
		
		case "adicionarcarrinho":
			try {
				String  pessoa = request.getParameter("pessoa");
			int idproduto  = Integer.parseInt(request.getParameter("idproduto"));
			ProdutoDTO p = produtoDAO.getProduto(idproduto);
			
			String tamanho = request.getParameter("tamanho");
			String sabor = request.getParameter("quantidadeSabores");
			String sab = request.getParameter("sabor");
		
			String sab2 = request.getParameter("sabo2");
			
			item  = item+1;
			
			Carrinho carrinho = new Carrinho();
			carrinho.setItem(item);
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTamanho(p.getTamanho());
			carrinho.setValorProduto(p.getValorProduto());
			listaCarrinho.add(carrinho);
			System.out.println(item);
			subtotal = subtotal+p.getValorProduto();
			proximo = "admin?acao=realizarPedido";
			request.setAttribute("itens", listaCarrinho);
			request.setAttribute("p", pessoa);
			request.setAttribute("total",subtotal );
			request.setAttribute("produto",p);
			}catch (Exception e) {
				request.setAttribute("msg", "cod 1: não foi possivel adicionar!");
				proximo = "admin?acao=realizarPedido";
			}
			System.out.println(subtotal);	
			break;
		case "finalizar":
			try {
					
				String  pessoa = request.getParameter("pessoa");
			String itItem  = request.getParameter("produto");
			if(pessoa.equals("0")&&itItem.equals("")) {
				request.setAttribute("msgErro", "cod 2: não foi possivel cadastrar campo cliente vazio!");
				System.out.println("ok");
			}else {
			ProdutoDTO p2 = produtoDAO.getProduto(Integer.parseInt(itItem));
			Pedido pedido = new Pedido();
			String data = sdf.format(Calendar.getInstance().getTime());
			pedido.setDataPedido(data);
			pedido.setValorPedido(subtotal);
			pedido.setValorTroco(0);
			pedido.setFuncionario(pessoaid.getIdPessoa());
			pedido.setIdcliente(Integer.parseInt(pessoa));
			pedido.setPagamento(1);
			System.out.println(idItemPedio);
			int idpedido = pedidoDAO.cadastrarPedido(pedido);
			int i=0;
			for (Carrinho lis: listaCarrinho) {
				ItemPedido ped = new ItemPedido();
				ped.setIdPedido(idpedido);
				ped.setQuantidade(item);
				ped.setIdProduto(p2.getIdProduto());
				ped.setTotal(pedido.getValorPedido()* ped.getQuantidade());
				ItemPedidoDAO idpd = new ItemPedidoDAO();
				i++;
				idpd.cadastrarItemPedido(ped);
			}
			
			listaCarrinho.clear();
				
			}
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("msg", "cod 1: não foi possivel cadastrar!");
				e.printStackTrace();
			}
			
					
				
			break;
	
			
			
		default:
			break;
		}
	
		
		request.getRequestDispatcher(proximo).forward(request, response);
	
	}
	

}
