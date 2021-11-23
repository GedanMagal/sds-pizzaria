package br.com.smartpizza.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.PessoaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.dto.PessoaDTO;
import br.com.smartpizza.dto.ProdutoDTO;
import br.com.smartpizza.model.Sabor;

public class RealizarPedido implements Command {
	private SaborDAO saborDAO;
	private ProdutoDAO produtoDAO;
	private PessoaDAO pessoa;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.saborDAO = new SaborDAO();
		this.produtoDAO = new ProdutoDAO();
		this.pessoa = new PessoaDAO();
		String proximo = "realizar-pedido.jsp";
		List<PessoaDTO> pessoas = pessoa.listaPessoas();
		List<Sabor> sabores = saborDAO.listaSAbores();
		List<ProdutoDTO> listaProdutos =  produtoDAO.listarProdutospizza(1);
		List<ProdutoDTO> listaProdutosbroto =  produtoDAO.listarProdutoPizzaBroto("Personalizada",1, "broto");
		request.setAttribute("prd", listaProdutos);
		request.setAttribute("brotos", listaProdutosbroto);
		request.getSession().setAttribute("sabores", sabores);
		request.getSession().setAttribute("pessoas", pessoas);
		return proximo;
	}

}
