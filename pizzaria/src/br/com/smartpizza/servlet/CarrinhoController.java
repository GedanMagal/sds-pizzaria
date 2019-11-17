package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.JsonObject;

import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Pagamento;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;
import br.com.smartpizza.model.Usuario;

@WebServlet(urlPatterns = {"/admin/carrinho", "/carrinho"})
public class CarrinhoController extends HttpServlet{
	private String proximo;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;
	private SaborDAO saborDAO;
	private PessoaDAO pessoaDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item =0;
	float subtotal= 0;                                                     
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.saborDAO = new SaborDAO();
		this.pedidoDAO = new PedidoDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		String acao =request.getParameter("acao");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject json = new JsonObject();
		int idItemPedio= 0;
		int quantidade = 1;
		Usuario id = (Usuario) request.getSession().getAttribute("loginUser");
		PessoaDTO pessoaid = pessoaDAO.getFuncionarioUsuario(id.getId());
		PrintWriter out = response.getWriter();
		switch (acao) {
		
		case "add":
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
			carrinho.setIdProdutp(p.getIdProduto());
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTotal(subtotal = subtotal+p.getValorProduto());
			carrinho.setTamanho(p.getTamanho());
			carrinho.setValorProduto(p.getValorProduto());
			listaCarrinho.add(carrinho);
			System.out.println(item);
		
			proximo = "admin?acao=realizarPedido";
			request.setAttribute("itens", listaCarrinho);
			request.setAttribute("p", pessoa);
			request.setAttribute("total",carrinho.getTotal() );
			request.setAttribute("produto",p);
			quantidade++;
			json.addProperty("pessoa", pessoa);
			json.addProperty("nome", p.getNomeProduto());

			json.addProperty("total", carrinho.getTotal());
			json.addProperty("nome", p.getNomeProduto());

			json.addProperty("idProduto", p.getIdProduto());
			json.addProperty("nome", p.getNomeProduto());
			out.print(json.toString());
			}catch (Exception e) {
				request.setAttribute("msg", "cod 1: não foi possivel adicionar!");
							}
			System.out.println(subtotal);	
			break;
		case "finalizar":
		
			try {
			String  pessoa = request.getParameter("pessoa");
			String itItem  = request.getParameter("produto");
			String troco = request.getParameter("troco");
			String valorPagamento = request.getParameter("valorPagamento");
			String cartao = request.getParameter("cartao");
			Pedido pedido = new Pedido();
			
			Pagamento pagamento =  new Pagamento();
			pagamento.setVlPagamento(Double.parseDouble(valorPagamento));
			
			pedido.setPagamento(pagamento);
			if(cartao==null||cartao.equals("")) {
				pagamento.setDsPagamento("dinheiro");
				pagamento.setTroco(Double.parseDouble(troco)-pagamento.getVlPagamento());
			}else {
				pagamento.setDsPagamento(cartao);
			}
		
			ProdutoDTO p2 = produtoDAO.getProduto(Integer.parseInt(itItem));
			
			String data = sdf.format(Calendar.getInstance().getTime());
			pedido.setDataPedido(data);
			pedido.setValorPedido(subtotal);
			
			pedido.setFuncionario(pessoaid.getIdPessoa());
			pedido.setIdcliente(Integer.parseInt(pessoa));
			
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
			json.addProperty("resposta","pedido finalizado!" );
			json.addProperty("datapedido", pedido.getDataPedido());
			json.addProperty("total", pedido.getValorPedido());
			out.print(json.toString());
			subtotal = 0;
			listaCarrinho.clear();
		
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("msg", "cod 1: não foi possivel cadastrar!");
				
				e.printStackTrace();
			}
			
			
				
			break;
		case "montar":
			String tamanho = request.getParameter("tamanho");
			
			String[] sab =  request.getParameterValues("sabores");
			String nomePerso = "";
			double maior = 0;
			Produto prod = new Produto();
			for(int i=0;i < sab.length; i++) {
				Sabor nomeSabor = saborDAO.getSabor(Integer.parseInt(sab[i]));
				nomePerso += "meio "+ nomeSabor.getDsSabor()+" ";
				maior = Math.max(nomeSabor.getPreco(), nomeSabor.getPreco());
				
			}
			
			
			System.out.println(nomePerso);
			prod.setNomeProduto(nomePerso);
			prod.setTamanho(tamanho);
			
			json.addProperty("resposta", nomePerso );
			out.print(json.toString());
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto(1);
			prod.setTipoProduto(tipoProd);
			prod.setValor(maior);
			Estoque estoque = new Estoque();
			estoque.setIdEstoque(1);
			prod.setEstoque(estoque);
			List<Sabor> ListaSabores = new ArrayList<Sabor>();
			for (String sabor: sab ) {
				Sabor s = new Sabor();
				s.setIdSabor(Integer.parseInt(sabor));
				ListaSabores.add(s);
			}
			prod.setSabor(ListaSabores);
			int idproduto = produtoDAO.cadastrarProduto(prod);
			produtoDAO.updatePrecoPizza(idproduto);
			if(tamanho.equals("broto")) {
				double preco = (prod.getValor()- prod.getValor()* 30/100);
				produtoDAO.updatePrecoPizzaBroto(idproduto, preco);
			}
			item  = item+1;
			
			Carrinho carrinho = new Carrinho();
			carrinho.setItem(item);
			carrinho.setIdProdutp(prod.getIdProduto());
			carrinho.setNomeProduto(prod.getNomeProduto());
			carrinho.setTotal(subtotal = (float) (subtotal+maior));
			carrinho.setTamanho(prod.getTamanho());
			carrinho.setValorProduto((float) prod.getValor());
			listaCarrinho.add(carrinho);
			json.addProperty("nome", prod.getNomeProduto());

			json.addProperty("total", carrinho.getTotal());
			json.addProperty("nome", prod.getNomeProduto());

			json.addProperty("idProduto", prod.getIdProduto());
			json.addProperty("nome", prod.getNomeProduto());
			out.print(json.toString());
			break;
		default:
			break;
		}
	

	}
	

}
