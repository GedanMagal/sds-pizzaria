package br.com.smartpizza.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

public class FinalizarPedidoCommand implements Command{
	private String proximo;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	private PessoaDAO pessoaDAO;
	List<Produto> lista = new ArrayList<Produto>();
	List<Carrinho> listaCarrinho = new ArrayList<Carrinho>();
	int item =0;
	double subtotal= 0.0; 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.pedidoDAO = new PedidoDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoaDAO = new PessoaDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int idItemPedio= 0;
		Usuario id = (Usuario) request.getSession().getAttribute("loginUser");
		PessoaDTO pessoaid = pessoaDAO.getFuncionarioUsuario(id.getId());
		proximo = "admin?acao=realizarPedido";
		try {
			String  pessoa = request.getParameter("pessoa");
			String itItem  = request.getParameter("produto");
		
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
			proximo = "admin?acao=realizarPedido";
			
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("msg", "cod 1: não foi possivel cadastrar!");
				proximo = "admin?acao=realizarPedido";
				e.printStackTrace();
			}
		return proximo;
	}

}
