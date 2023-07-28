package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class FiltroSeguranca implements Filter {
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// faz alguma coisa antes de repassar a requisição para a servlet
		System.out.println("FiltroSeguranca recebeu a requisição");
		
		chain.doFilter(request, response);
		
		// faz alguma coisa depois de receber a resposta
		System.out.println("FiltroSeguranca recebeu a resposta");
	}

	

}
