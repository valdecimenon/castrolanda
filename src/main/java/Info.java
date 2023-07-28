import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> parametros = request.getParameterNames();
		StringBuilder builder = new StringBuilder();

		while (parametros.hasMoreElements()) {
			String paramNome = parametros.nextElement();
			String paramValor = request.getParameter(paramNome);
			builder.append(paramNome + " = " + paramValor + "<br>");
		}

		response.setContentType("text/html; charset=UTF-8");
		out.println("<h2>Resposta da Servlet Info</h2>");
		out.println("<h3>Lista de parâmetros</h3>");
		out.println("<p>" + builder.toString() + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
