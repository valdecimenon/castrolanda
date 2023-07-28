

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class OlaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	public void init() throws ServletException {
		// abre as conexões
		System.out.println("\nInicializando a servlet OlaMu	ndo");
		// necessário
		super.init();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Tempo máximo de inatividade: " + request.getSession().getMaxInactiveInterval());
		response.getWriter().print("<h1>Servlet OlaMundo</h1>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		// fecha as conexões
		System.out.println("Finalizando a servlet OlaMundo");
		// necessário
		super.destroy();
	}
	
}
