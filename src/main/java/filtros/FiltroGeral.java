package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class FiltroGeral implements Filter {
	
	private FilterConfig fConfig;
       
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FiltroGeral init()");
		this.fConfig = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// faz alguma coisa antes de repassar a requisição para a servlet
		System.out.println("FiltroGeral recebeu a requisição");
		
		chain.doFilter(request, response);
		
		// faz alguma coisa depois de receber a resposta
		System.out.println("FiltroGeral recebeu a resposta");
	}


	public void destroy() {
		System.out.println("FiltroGeral destroy()");
		Filter.super.destroy();
	}

}
