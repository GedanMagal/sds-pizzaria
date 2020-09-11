package br.com.smartpizza.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.smartpizza.dao.ProdutoDAOImpl;
import br.com.smartpizza.model.Estoque;
import br.com.smartpizza.model.Ingrediente;
import br.com.smartpizza.model.Produto;
import br.com.smartpizza.model.Tamanho;
import br.com.smartpizza.model.TipoProduto;

public class CadastroProdutoCommand implements Command{
	@Autowired
	private ProdutoDAOImpl produtoDAO;
	@Autowired
	private Tamanho tamanho;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String proximo = "admin?acao=listaprodutos";
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		System.out.println("ok");
		if(tipo==1) {
			String tamanhoDesc = request.getParameter("tamanho");
			String valor = request.getParameter("valor");
			String sab =  request.getParameter("sabores");
			Produto prod = new Produto();
			tamanho.setDsTamanho(tamanhoDesc);
			prod.setTamanho(tamanho);
			prod.setValor(Float.parseFloat(valor));
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto((long) tipo);
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			estoque.setIdEstoque(1L);
			prod.setEstoque(estoque);
			List<Ingrediente> Ingredientes = new ArrayList<Ingrediente>();
			
			Ingrediente s = new Ingrediente();
				
			
			produtoDAO.save(prod);
		}else {
			String nomeProd = request.getParameter("descricao");
			String tamanhoDesc = request.getParameter("tamanho");
			String valor = request.getParameter("valor");
			String[] sab =  request.getParameterValues("sabores");
			String quantidade = request.getParameter("quantidade");
			Produto prod = new Produto();
			prod.setNomeProduto(nomeProd);
			tamanho.setDsTamanho(tamanhoDesc);
			prod.setTamanho(tamanho);
			prod.setValor(Float.parseFloat(valor));
			TipoProduto tipoProd = new TipoProduto();
			tipoProd.setIdTipoProduto((long) tipo);
			prod.setTipoProduto(tipoProd);
			Estoque estoque = new Estoque();
			prod.setEstoque(estoque);
			estoque.setQtdEstoque(Integer.parseInt(quantidade));
			
			
			produtoDAO.save(prod);
		}
		
		return proximo;
	}

}
