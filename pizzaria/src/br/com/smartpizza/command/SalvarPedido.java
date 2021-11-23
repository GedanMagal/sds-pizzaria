package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.ItemPedido;
import br.com.smartpizza.model.Pedido;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;

public class SalvarPedido implements Command {
	private ProdutoDAO produtoDAO;
	private TipoProdutoDAO tipoDAO;
	private SaborDAO saborDAO;
	private ItemPedidoDAO itemPedodaDAO;
	int quantidadeSabor = 0;
	int quantidade =0;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
		this.tipoDAO = new TipoProdutoDAO();
		this.saborDAO = new SaborDAO();
		this.itemPedodaDAO = new ItemPedidoDAO();
		String proximo = "pedido.jsp";
		List<Produto> produtos = new ArrayList<Produto>();
		String param = request.getParameter("param");
		if(param.equals("pizza")) {
		int quantidadeSabor = Integer.parseInt(request.getParameter("quantidadeSabor"));
		proximo = "pedido.jsp";
		
		
		String ingredientes[] = request.getParameterValues("ingredientes");
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		List<TipoProduto> tipos = tipoDAO.listaTipos();
	
		request.setAttribute("produtos", listaProdutos);
		request.setAttribute("tiposProdutos", tipos);
	
		
		}else if(param.equals("prod")) {
			String produto = request.getParameter("produto");
			proximo = "pedido.jsp";
			List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
			List<TipoProduto> tipos = tipoDAO.listaTipos();
			
			request.setAttribute("produtos", listaProdutos);
			request.setAttribute("tiposProdutos", tipos);
			if(quantidadeSabor==1) {
			}
		}else if(param.equals("finalizar")) {
			proximo = "relatorio-pedidos.jsp";
		}
	
		return proximo;
	}
	
}
