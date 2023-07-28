package com.softgraf.vendas;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// carregamento automático
@WebServlet(value = "/servletd", loadOnStartup = 3, initParams = {
		@WebInitParam(name = "contato", value = "d@vendas.com"),
		@WebInitParam(name = "preco", value = "39,99")
})
public class ServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Iniciando ServletD");
		this.config = config;
		System.out.println(config.getInitParameter("contato"));
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		// lendo e retornando os parâmetros de inicialização da servlet
		out.append("<h1>ServletD</h1>");
		out.append("<h3>Contato: " + config.getInitParameter("contato") + "</h3>");
		out.append("<h3>Preço: R$ " + config.getInitParameter("preco") + "</h3>");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
