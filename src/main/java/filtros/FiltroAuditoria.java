package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// a definição da ordem de execução só é possível através do web.xml
@WebFilter("/*")
public class FiltroAuditoria implements Filter {
	
	private FilterConfig fConfig;
       
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FiltroAuditoria init()");
		this.fConfig = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// faz alguma coisa antes de repassar a requisição para a servlet
		System.out.println("FiltroAuditoria recebeu a requisição");
		
		chain.doFilter(request, response);
		
		// faz alguma coisa depois de receber a resposta
		System.out.println("FiltroAuditoria recebeu a resposta");
	}


	public void destroy() {
		System.out.println("FiltroAuditoria destroy()");
		Filter.super.destroy();
	}

}
