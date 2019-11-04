package br.com.smartpizza.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ClienteFilter
 */
@WebFilter(urlPatterns = {"/admin/*","/adminis/*"})	
public class FuncFilter implements Filter {

	
	private static final String[] URLS_TO_EXCLUDE = {".css", ".js", ".png", ".gif", "index.jsp","login.jsp"};
    /**
     * Default constructor. 
     */
    public FuncFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String uri = httpRequest.getRequestURI();
		
		if (!isURIToExclusao(uri, httpRequest)) {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("loginUser") == null) {
				request.setAttribute("msgErro", "Acesso negado! Você precisar logar primeiro.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private boolean isURIToExclusao(String uri, HttpServletRequest httpRequest) {
		boolean retorno = false;
		for (String url : URLS_TO_EXCLUDE) {
			if (uri != null && uri.endsWith(url)) {
				retorno = true;
			}
			
			if (uri != null && uri.endsWith("admin")
					&& (httpRequest.getParameter("acao") != null
					&& httpRequest.getParameter("acao").equals("loginUser"))) {
				retorno = true;
			}
			else if(uri != null && uri.endsWith("adminis")
					&& (httpRequest.getParameter("acao") != null
					&& httpRequest.getParameter("acao").equals("loginUser"))) {
				
			}
			
		}
		return retorno;
	}
}
