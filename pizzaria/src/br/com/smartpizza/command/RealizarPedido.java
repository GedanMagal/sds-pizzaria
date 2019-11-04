package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Sabor;

public class RealizarPedido implements Command {
	private SaborDAO saborDAO;
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.saborDAO = new SaborDAO();
		this.produtoDAO = new ProdutoDAO();
		String proximo = "realizar-pedido.jsp";
		List<Sabor> sabores = saborDAO.listaSAbores();
		List<ProdutoDTO> listaProdutos =  produtoDAO.listarProdutospizza("Personalizada",1);
		request.setAttribute("prd", listaProdutos);
		request.getSession().setAttribute("sabores", sabores);
		return proximo;
	}

}
