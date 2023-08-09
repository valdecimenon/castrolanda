package com.softgraf.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FiltroJPA implements Filter {

	private EntityManagerFactory factory;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("\nFiltro init()");
		// Abre a conexão com o banco de dados
		this.factory = Persistence.createEntityManagerFactory("softgraf_pu");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		EntityTransaction tx = null;
		EntityManager em = null;

		try {
			em = this.factory.createEntityManager();
			request.setAttribute("em", em);
			tx = em.getTransaction();
			System.out.println("\nIniciou a transação...");
			tx.begin();
			
			// executa a servlet (página) chamada
			System.out.println("\ndoFilter()");
			chain.doFilter(request, response);

			tx.commit();
			System.out.println("\nFinalizou a transação...");

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			
		} finally {
			if (em != null)
				em.close();
		}
	}

	public void destroy() {
		System.out.println("\nFiltro destroy()");
		// Fecha a conexão com o banco de dados
		this.factory.close();
	}

}
