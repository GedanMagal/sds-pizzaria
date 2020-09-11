package br.com.smartpizza.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;

import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.model.Pessoa;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Usuario;

@WebServlet(urlPatterns = {"/admin/carrinho", "/carrinho"})
public class CarrinhoController extends HttpServlet{
	private String proximo;
	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private ProdutoDAOImpl produtoDAO;
	@Autowired
	private PessoaDAOImpl pessoaDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	Long item =0L;
	float subtotal= 0;                                                     
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		String acao =request.getParameter("acao");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonObject json = new JsonObject();
		Long idItemPedio= 0L;
		Long quantidade = 1l;
		Usuario id = (Usuario) request.getSession().getAttribute("loginUser");
		Pessoa pessoaid = pessoaDAO.findById(id.getId());
		PrintWriter out = response.getWriter();
		switch (acao) {
		
		case "add":
			try {
				
			String  pessoa = request.getParameter("pessoa");
			Long idproduto  = Long.parseLong(request.getParameter("idproduto"));
			Produto p = produtoDAO.findById(idproduto);
			
			String tamanho = request.getParameter("tamanho");
			String sabor = request.getParameter("quantidadeSabores");
			String sab = request.getParameter("sabor");
		
			String sab2 = request.getParameter("sabo2");
			
			item  = item+1;
			
			Carrinho carrinho = new Carrinho();
			carrinho.setItem(item);
			carrinho.setIdProdutp(p.getIdProduto());
			carrinho.setNomeProduto(p.getNomeProduto());
			carrinho.setTotal(subtotal = (float) (subtotal+p.getValor()));
			carrinho.setTamanho(p.getTamanho());
			carrinho.setValorProduto((float) p.getValor());
			listaCarrinho.add(carrinho);
			System.out.println(item);
		
			proximo = "admin?acao=realizarPedido";
			request.setAttribute("itens", listaCarrinho);
			request.setAttribute("p", pessoa);
			request.setAttribute("total",carrinho.getTotal() );
			request.setAttribute("produto",p);
			quantidade++;
			json.addProperty("pessoa", pessoa);
			

			json.addProperty("total", carrinho.getTotal());
			

			json.addProperty("idProduto", p.getIdProduto());
			json.addProperty("nome", p.getNomeProduto());
			out.print(json.toString());
			}catch (Exception e) {
				request.setAttribute("msg", "cod 1: não foi possivel adicionar!");
							}
			System.out.println(subtotal);	
			break;
		case "finalizar":
//		
//			try {
//			String  pessoa = request.getParameter("pessoa");
//			String[] itItem  = request.getParameterValues("itemproduto");
//			String troco = request.getParameter("troco");
//			String valorPagamento = request.getParameter("valorPagamento");
//			String tamanho = request.getParameter("tamanho");
//			String cartao = request.getParameter("cartao");
//			
//			
//			Pagamento pagamento =  new Pagamento();
//			pagamento.s(Double.parseDouble(valorPagamento));
//			pagamento.setTroco(pagamento.getVlPagamento() - pedido.getValorPedido());
//			pedido.setPagamento(pagamento);
//			if(cartao==null||cartao.equals("")) {
//				pagamento.setDsPagamento("dinheiro");
//				pagamento.setTroco(Double.parseDouble(troco)-pagamento.getVlPagamento());
//			}else {
//				pagamento.setDsPagamento(cartao);
//			}
			
			Pedido pedido = new Pedido();
			String data = sdf.format(Calendar.getInstance().getTime());
			pedido.setDataPedido(data);
			pedido.setValorPedido(subtotal);
//			pedido.setValorTroco(pagamento.getTroco());
//			pedido.setFuncionario(pessoaid.getIdPessoa());
//			pedido.setIdcliente(Integer.parseInt(pessoa));
			
			System.out.println(idItemPedio);
			//int idpedido = pedidoDAO.cadastrarPedido(pedido);
			int i=0;
			List<ItemPedido> listaItens = new ArrayList<ItemPedido>();
//			for (Carrinho lis: listaCarrinho) {
//				for(String p: itItem)
//				{
//					ProdutoDTO p2 = produtoDAO.getProdutoById(Integer.parseInt(p));
//				
//				
//				ItemPedido ped = new ItemPedido();
//				ped.setIdPedido(idpedido);
//				ped.setQuantidade(item);
//				ped.setIdProduto(p2.getIdProduto());
//				listaItens.add(ped);
//				ped.setTotal(pedido.getValorPedido()* ped.getQuantidade());
//				ItemPedidoDAO idpd = new ItemPedidoDAO();
//				i++;
//				idpd.cadastrarItemPedido(ped);
//				}
//			}
			json.addProperty("resposta","pedido finalizado!" );
			json.addProperty("datapedido", pedido.getDataPedido());
			json.addProperty("total", pedido.getValorPedido());
			out.print(json.toString());
			subtotal = 0;
			listaCarrinho.clear();
		
//			} catch (ClassNotFoundException | SQLException e) {
//				request.setAttribute("msg", "cod 1: não foi possivel cadastrar!");
//				
//				e.printStackTrace();
//			}
			
			
				
			break;
		case "montar":
//			String tamanho = request.getParameter("tamanho");
//			
//			String[] sab =  request.getParameterValues("sabores");
//			String nomePerso = "";
//			double maior = 0;
//			Produto prod = new Produto();
//			for(int i=0;i < sab.length; i++) {
//				Sabor nomeSabor = saborDAO.getSabor(Integer.parseInt(sab[i]));
//				nomePerso += "meio "+ nomeSabor.getDsSabor()+" ";
//				maior = Math.max(nomeSabor.getPreco(), nomeSabor.getPreco());
//				
//			}
//			
//			
//			System.out.println(nomePerso);
//			prod.setNomeProduto(nomePerso);
//			prod.setTamanho(tamanho);
//		
//			TipoProduto tipoProd = new TipoProduto();
//			tipoProd.setIdTipoProduto(1);
//			prod.setTipoProduto(tipoProd);
//			prod.setValor(maior);
//			Estoque estoque = new Estoque();
//			estoque.setIdEstoque(1);
//			prod.setEstoque(estoque);
//			List<Sabor> ListaSabores = new ArrayList<Sabor>();
//			for (String sabor: sab ) {
//				Sabor s = new Sabor();
//				s.setIdSabor(Integer.parseInt(sabor));
//				ListaSabores.add(s);
//			}
//			prod.setSabor(ListaSabores);
//			int idproduto = produtoDAO.cadastrarProduto(prod);
//			produtoDAO.updatePrecoPizza(idproduto);
//			if(tamanho.equals("broto")) {
//				double preco = (prod.getValor()- prod.getValor()* 30/100);
//				produtoDAO.updatePrecoPizzaBroto(idproduto, preco);
//			}
			item  = item+1;
//			
//			Carrinho carrinho = new Carrinho();
//			carrinho.setItem(item);
//			carrinho.setIdProdutp(prod.getIdProduto());
//			carrinho.setNomeProduto(prod.getNomeProduto());
//			carrinho.setTotal(subtotal = (float) (subtotal+maior));
//			carrinho.setTamanho(prod.getTamanho());
//			carrinho.setValorProduto((float) prod.getValor());
//			listaCarrinho.add(carrinho);
//			json.addProperty("nome", prod.getNomeProduto());
//			json.addProperty("preco", prod.getValor());
//			json.addProperty("total", carrinho.getTotal());
//			json.addProperty("idProduto", prod.getIdProduto());
//			out.print(json.toString());
			break;
		default:
			break;
		}
	

	}
	

}
