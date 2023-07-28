package com.softgraf.vendas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//carregamento automático via web.xml -> load-on-startup 
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;


	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Iniciando ServletA");
		
		// lendo parâmeto de inicialização definido em web.xml
		this.config = config;
		System.out.println(config.getInitParameter("contato"));
		super.init();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * tipos de conteúdo que podem ser retornados:
		 * htm, html, text, gif, jpf, png, pdf, zip
		 * text/html, text/plain, images/gif, images/jpeg, images/x-png, application/pdf, application/zip, etc
		 */
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		// lendo e retornando os parâmetros de inicialização da servlet
		out.append("<h1>ServletA</h1>");
		out.append("<h3>Contato: " + config.getInitParameter("contato") + "</h3>");
		out.append("<h3>Preço: R$ " + config.getInitParameter("preco") + "</h3>");
		out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
