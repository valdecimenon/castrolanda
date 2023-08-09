package com.softgraf.controller;

import java.io.IOException;

import javax.persistence.EntityManager;

import com.softgraf.entity.Candidato;
import com.softgraf.model.Sexo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/cadastrar"})
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = (EntityManager) request.getAttribute("em");
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		Sexo sexo = Sexo.valueOf(request.getParameter("radioSexo"));  // "MASCULINO" ou "FEMININO"
		String cidade = request.getParameter("radioCidade");
		
		Boolean java = request.getParameter("checkJava") != null;  				// "on" ou null
		Boolean javascript = request.getParameter("checkJavascript") != null;   // "on" ou null
		Boolean python = request.getParameter("checkPython") != null;  			// "on" ou null
				
		Candidato candidato = new Candidato(nome, sobrenome, sexo, cidade, java, javascript, python);
		
		em.persist(candidato);
		
		response.sendRedirect(getServletContext().getContextPath() + "/resultado.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
