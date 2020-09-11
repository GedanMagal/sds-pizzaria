package br.com.smartpizza.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.PedidoDAO;
import br.com.smartpizza.dao.PessoaDAOImpl;
import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.model.Carrinho;
import br.com.smartpizza.model.Produto;

public class AdicionaCArrinhoCommand implements Command{
	private String proximo;
	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private ProdutoDAOImpl produtoDAO;

	private PessoaDAOImpl pessoaDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item =0;
	double subtotal= 0.0;      
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		proximo = "admin?acao=realizarPedido";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		String  pessoa = request.getParameter("pessoa");
		int idproduto  = Integer.parseInt(request.getParameter("idproduto"));
		Produto p = produtoDAO.findById((long) idproduto);
		
		String tamanho = request.getParameter("tamanho");
		String sabor = request.getParameter("quantidadeSabores");
		String sab = request.getParameter("sabor");
	
		String sab2 = request.getParameter("sabo2");
		
		item  = item+1;
		
		Carrinho carrinho = new Carrinho();
		carrinho.setItem((long) item);
		carrinho.setNomeProduto(p.getNomeProduto());
		carrinho.setTamanho(p.getTamanho());
		carrinho.setValorProduto((float) p.getValor());
		listaCarrinho.add(carrinho);
		System.out.println(item);
		subtotal = subtotal+p.getValor();
		proximo = "admin?acao=realizarPedido";
		request.setAttribute("itens", listaCarrinho);
		request.setAttribute("p", pessoa);
		request.setAttribute("total",subtotal );
		request.setAttribute("produto",p);
		}catch (Exception e) {
			request.setAttribute("msg", "cod 1: não foi possivel adicionar!");
			proximo = "admin?acao=realizarPedido";
		}
		return proximo;
	}

}
