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
		String proximo = "admin?acao=listaprodutos";
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		System.out.println("ok");
		if(tipo==1) {
			String nomeProd = request.getParameter("descricao");
			String tamanho = request.getParameter("tamanho");
			String valor = request.getParameter("valor");
			String[] sab =  request.getParameterValues("sabores");
		
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			prod.setTamanho(tamanho);
			prod.setValor(Float.parseFloat(valor));
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto(tipo);
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			estoque.setIdEstoque(1);
			prod.setEstoque(estoque);
			List<Sabor> ListaSabores = new ArrayList<Sabor>();
			for (String sabor: sab ) {
				Sabor s = new Sabor();
				s.setIdSabor(Integer.parseInt(sabor));
				ListaSabores.add(s);
			}
			prod.setSabor(ListaSabores);
			produtoDAO.cadastrarProduto(prod);
		}else {
			String nomeProd = request.getParameter("descricao");
			String tamanho = request.getParameter("tamanho");
			String valor = request.getParameter("valor");
			String[] sab =  request.getParameterValues("sabores");
			String quantidade = request.getParameter("quantidade");
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			prod.setTamanho(tamanho);
			prod.setValor(Float.parseFloat(valor));
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto(tipo);
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			prod.setEstoque(estoque);
			estoque.setQtdEstoque(Integer.parseInt(quantidade));
			
			
			produtoDAO.cadastrarProdutoBebidas(prod);
		}
		
		return proximo;
	}

}
