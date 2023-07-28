package servlet_cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class Listar extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.append("<html><head><title>Cookies</title></head>");
		
		// recupera cookies recebidos no objeto request
		Cookie[] cookies = req.getCookies();
		
		// quantos cookies tenho nesta aplicação?
		int quant = cookies != null ? cookies.length : 0;
		out.append("<h3>Cookies encontrados: " + quant + "</h3>");
		
		// processa cada cookie e adiciona nome e valor ao html
		for (int i=0; i<quant; i++) {
			Cookie cookie = cookies[i];
			// um cookie é formado por um nome e um valor
			out.append("Cookie nome: " + cookie.getName() + "<br>");
			out.append("Cookie valor: " + cookie.getValue() + "<br>");
			// por padrão retorna -1
			out.append("Cookie tempo: " + cookie.getMaxAge() + "<br><br>");
		}
		
		out.append("<a href='/servlet_cookies/'>Adicionar Cookies</a><br></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
