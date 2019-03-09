package br.unitins.unibio.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.unibio.model.Pessoa;

@WebFilter(filterName="securityFilter", urlPatterns ="/pages/*")
public class SecurityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//autorizando tudo
		chain.doFilter(request, response);
		return;
		
	/*	*******
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		// imprime o endereco da pagina solicitada
		System.out.println(servletRequest.getRequestURI());
		
		
		HttpSession session = servletRequest.getSession(false);
		Pessoa pessoa = null;
		
		if (session != null)
			pessoa = (Pessoa) session.getAttribute("usuarioLogado");
													  
		if (pessoa == null) {
			((HttpServletResponse) response).sendRedirect("/UniBio/login.xhtml"); 
		} else {
			String endereco = servletRequest.getRequestURI();
			for (String pagina : pessoa.getTipoUsuario().getPages()) {
				if (endereco.contains(pagina)) {
					chain.doFilter(request, response);
					return;
				}
			}
			
			((HttpServletResponse) response).sendRedirect("/UniBio/sempermissao.xhtml");
		}
		** */
	}
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		
		System.out.println("\n\n\n\n\n iniciou o Security Filter \n\n\n\n\n\n");
	}
	

}
