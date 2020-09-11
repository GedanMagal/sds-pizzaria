package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.ItemPedidoDAO;
import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.dao.TipoProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.TipoProduto;

public class SalvarPedido implements Command {
	@Autowired
	private ProdutoDAOImpl produtoDAO;
	@Autowired
	private TipoProdutoDAO tipoDAO;
	@Autowired
	private ItemPedidoDAO itemPedodaDAO;
	int quantidadeSabor = 0;
	int quantidade =0;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String proximo = "pedido.jsp";
		List<Produto> produtos = new ArrayList<Produto>();
		String param = request.getParameter("param");
		if(param.equals("pizza")) {
		int quantidadeSabor = Integer.parseInt(request.getParameter("quantidadeSabor"));
		proximo = "pedido.jsp";
		
		
		String ingredientes[] = request.getParameterValues("ingredientes");
		List<Produto> listaProdutos = produtoDAO.listAll();
		List<TipoProduto> tipos = tipoDAO.listAll();
	
		request.setAttribute("produtos", listaProdutos);
		request.setAttribute("tiposProdutos", tipos);
	
		
		}else if(param.equals("prod")) {
			String produto = request.getParameter("produto");
			proximo = "pedido.jsp";
			List<Produto> listaProdutos = produtoDAO.listAll();
			List<TipoProduto> tipos = tipoDAO.listAll();
			
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
