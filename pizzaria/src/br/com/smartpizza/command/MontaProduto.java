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

public class MontaProduto implements Command {
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		this.produtoDAO = new ProdutoDAO();
			String  proximo ="admin?acao=cadastrarSaborPizza";
			String nomeProd = "pizza +1 sabor";
		
			String tamanho = request.getParameter("tamanho");
			
			String quantidade = request.getParameter("quantidade");
			
			String[] sab =  request.getParameterValues("sabor");
			String valor = request.getParameter("valor");
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			prod.setTamanho(tamanho);
			prod.setValor(0.0);
			TipoProduto tipoProd = new TipoProduto();
			prod.setTipoProduto(tipoProd);
			tipoProd.setIdTipoProduto(1);
			Estoque estoque = new Estoque();
			prod.setEstoque(estoque);
			
			estoque.setQtdEstoque(Integer.parseInt(quantidade));
			List<Sabor> ListaSabores = new ArrayList<Sabor>();
			for (String sabor: sab ) {
				Sabor s = new Sabor();
				s.setIdSabor(Integer.parseInt(sabor));
				ListaSabores.add(s);
			}
			prod.setSabor(ListaSabores);
			produtoDAO.cadastrarProduto(prod);
		
		return proximo;
	}

}
