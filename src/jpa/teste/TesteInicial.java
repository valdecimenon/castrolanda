package jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.entity.Cliente;

public class TesteInicial {

	public static void main(String[] args) {
		Cliente ambrosio = new Cliente("Ambrosio");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("softgraf_pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		// inicia transação
		tx.begin();
		em.persist(ambrosio);
		tx.commit();
		
		em.close();
		emf.close();

	}

}
