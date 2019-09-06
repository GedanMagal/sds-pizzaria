package br.com.smartpizza.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("CadastraCliente"))
			System.out.println("CadastrandoClientes");
		
		
		
	}
}
