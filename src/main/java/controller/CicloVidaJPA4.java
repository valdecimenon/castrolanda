package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import util.JpaUtil;

//<property name="hibernate.hbm2ddl.auto" value="update" />
public class CicloVidaJPA4 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 1. Estado MANAGED
		User u1 = em.find(User.class, 1L);  // Helena
		User u2 = em.find(User.class, 5L);  // Ellon
		User u3 = em.find(User.class, 8L);  // Bill
		
		// 2. Estado REMOVED
		// remove do gerenciador, portanto muda para o estado NEW
		em.remove(u2);
		em.remove(u3);
		
		// 3. Estado MANAGED
		// vai do estado NEW para MANAGED
		// objeto não será mais removido
		em.persist(u2);
		// objeto será atualizado no gerenciador
		u1.setNome("Marie Curie");
		
		// 4. Estado DETACHED
		// Objeto é desanexado do gerenciador
		// não será mais atualizado no banco
		em.detach(u1);
		u1.setNome("Maria Carla");
		System.out.println(u1.getNome());
		
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
