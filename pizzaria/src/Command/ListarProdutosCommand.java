package Command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.smartpizza.dao.ProdutoDAO;
import br.com.smartpizza.dto.ProdutoDTO;

public class ListarProdutosCommand implements Command {
	private ProdutoDAO produtoDAO;
	@Override
	public String execute(HttpServletRequest request) {
		this.produtoDAO = new ProdutoDAO();
		String proximo = "gerenciar-produto.jsp";
		
		List<ProdutoDTO> listaProdutos = produtoDAO.listarProdutos();
		request.setAttribute("produtos", listaProdutos);
		
		
		return proximo;
	}

}
