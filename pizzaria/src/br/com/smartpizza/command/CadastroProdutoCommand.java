package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;

public class CadastroProdutoCommand implements Command{
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		 this.produtoDAO = new ProdutoDAO();
		String proximo = "cadastrar-produto.jsp";
		
		String nomeProd = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		String tamanho = request.getParameter("tamanho");
		String valor = request.getParameter("valor");
		String quantidade = request.getParameter("quantidade");
		
		String[] sab =  request.getParameterValues("sabor");
		Produto prod = new Produto();
		prod.setNomeProduto(nomeProd);
		prod.setTamanho(tamanho);
		prod.setValor(Float.parseFloat(valor));
		TipoProduto tipoProd = new TipoProduto();
		prod.setTipoProduto(tipoProd);
		tipoProd.setIdTipoProduto(Integer.parseInt(tipo));
		Estoque estoque = new Estoque();
		prod.setEstoque(estoque);
		Sabor s = new Sabor();
		estoque.setQtdEstoque(Integer.parseInt(quantidade));
		List<Sabor> ListaSabores = new ArrayList<Sabor>();
		for (String sabor: sab ) {
			
			s.setDsSabor(sabor);
			ListaSabores.add(s);
		}
		
		produtoDAO.cadastrarProduto(prod);
		proximo = "admin?acao=listaprodutos";
		return proximo;
	}

}
