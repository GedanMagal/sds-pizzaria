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
<<<<<<< HEAD
		String proximo = "";
		
			String tamanho = request.getParameter("tamnho");
			String nomeprodudo = "pizza";
			
		return null;
=======
		this.produtoDAO = new ProdutoDAO();
			//int idCliente =  Integer.parseInt(request.getParameter("idCliente"));
			String  proximo ="admin?acao=cadastrarSaborPizza";
			String nomeProd = "pizza +1 sabor";
		
			String tamanho = request.getParameter("tamanho");
		
			
			String[] sab =  request.getParameterValues("sabor");
		
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			prod.setTamanho("8 Pedaços");
			prod.setValor(0.0);
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto(1);
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			
			prod.setEstoque(estoque);
			
			estoque.setQtdEstoque(-1);
			Sabor s = new Sabor();
			List<Sabor> ListaSabores = new ArrayList<Sabor>();
			for (String sabor: sab ) {
				
				s.setIdSabor(Integer.parseInt(sabor));
				ListaSabores.add(s);
			}
			prod.setSabor(ListaSabores);
			request.setAttribute("produto", prod);
			System.out.println(prod.getNomeProduto());
			
		
		return proximo;
>>>>>>> ccc4e55ffc28c8a8783924dd3a01ac64883676b2
	}

}
