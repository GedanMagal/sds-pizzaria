package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.smartpizza.dao.IngredientaDAO;
import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dao.SaborDAO;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Sabor;
import br.com.smartpizza.model.TipoProduto;

public class MontaProduto implements Command {
	private String proximo;
	
	private ProdutoDAO produtoDAO;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
	
	
			
		

			//int idCliente =  Integer.parseInt(request.getParameter("idCliente"));
			  proximo ="admin?acao=cadastrarSaborPizza";
			String nomeProd = "pizza +1 sabor";
			String tamanho = request.getParameter("tamanho");
			
			String[] sab =  request.getParameterValues("sabor");
		
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			prod.setTamanho(tamanho);
			prod.setValor(0.0);
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto(1);
			tipoProd.setDsTipoProduto("pizza");
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			
			prod.setEstoque(estoque);
			
			estoque.setQtdEstoque(-1);
			
			List<Sabor> ListaSabores = new ArrayList<Sabor>();
			for (String sabor: sab ) {
				Sabor s = new Sabor();
				s.setIdSabor(Integer.parseInt(sabor));
				ListaSabores.add(s);
			}
			prod.setSabor(ListaSabores);
			produtoDAO.cadastrarProdutoPizza(prod);
			
		
		return proximo;
	}

}