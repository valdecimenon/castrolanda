package servlet_cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adicionar")
public class Adicionar extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cookieNome = req.getParameter("cookienome");
		String cookieValor = req.getParameter("cookievalor");
		int cookieTempo = Integer.parseInt(req.getParameter("cookietempo"));
		
		Cookie cookie = new Cookie(cookieNome, cookieValor);
		// define a duração do cookie
		// -1 = dura até o navegador ser fechado
		// > 0 = indica o tempo máximo de duração
		// 0 = deleta o cookie
		cookie.setMaxAge(cookieTempo);
		resp.addCookie(cookie);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.append("<html>" +
				   "<head><title>Cookies</title></head>" + 
				   "<body>" + 
				   "<h3>Cookie adicionado</h3>" + 
				   "Nome: " +  cookie.getName() + "<br>" +
				   "Valor: " + cookie.getValue() + "<br>" +
				   "Tempo: " + cookie.getMaxAge() + "<br>" +
				   "<br>" + 
				   "<a href='/servlet_cookies/'>Adicionar Cookies</a><br>" + 
				   "<a href='/servlet_cookies/listar'>Listar Cookies</a><br>" + 
				   "</body>" + 
				   "</html>" 			
				);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
