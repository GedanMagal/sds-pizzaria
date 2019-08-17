package br.com.smartpizza.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.smartpizza.dao.Acao;

@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehAcaoProtegida = !(paramAcao.equals("login") || paramAcao.equals("LoginPrincipal"));

		if (ehAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("pizzaria/acao=LoginPrincipal");
			return;
		}

		String nomeDaClasse = "br.com.pizzaria.acao." + paramAcao;

		String nome;

		try {
			Class classe = Class.forName(nomeDaClasse); // Carrega o nome da classe
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException();
		}
		
		String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEndereco[1]);

        }

	}

}
