package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import util.JpaUtil;

//<property name="hibernate.hbm2ddl.auto" value="update" />
public class CicloVidaJPA3 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 1. Estado NEW
		User u1 = new User("Ellon Musk");
		User u2 = new User("Bill Gates");
		
		// 2. Estado MANAGED - com persist()
		// Tentativa de persistir várias vezes o mesmo objeto:
		// porque? persiste apenas adiciona a instância no gerenciador
		em.persist(u1);
		em.persist(u1);
		em.persist(u1);
		
		// 3. Estado MANAGED - com merge() 
		// consgue persistir várias vezes o mesmo objeto, pois o
		// método merge() cria uma nova instância para cada execução
		em.merge(u2);
		em.merge(u2);
		em.merge(u2);
		
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
