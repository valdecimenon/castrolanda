import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/index"})
@WebFilter("/*")
public class Autenticacao extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("método doGet() executado.");
		
		req.getRequestDispatcher("/principal.html").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("\n==== doFilter() iniciado");
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// obtém session atual. false = retorna null
		HttpSession session = req.getSession(false);
		
		// já está logado
		if (session != null && session.getAttribute("login") != null) {
			// reenvia a requisação para a servlet (método get)
			chain.doFilter(req, resp);
			// não está logado e requisição está vindo da tela de login -> faz login
		} else if (nome != null && nome.equalsIgnoreCase("valdeci") && senha != null && senha.equals("123")) {
			
			// true = cria session
			session = req.getSession(true);
			session.setAttribute("login", nome);
			chain.doFilter(req, resp);
		
			// não está logado e requisição vem de outra origem
		} else {
			req.getRequestDispatcher("/login.html").forward(req, resp);
		}
		
		System.out.println("\n==== doFilter() finalizado");	
	}
}
