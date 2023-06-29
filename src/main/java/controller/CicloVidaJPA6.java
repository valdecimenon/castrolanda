package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import util.JpaUtil;

//<property name="hibernate.hbm2ddl.auto" value="update" />
public class CicloVidaJPA6 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 1. Estado MANAGED
		User u1 = em.find(User.class, 3L);  // Alberto Roberto
		
		// 2. Estado MANAGED
		// atualiza no gerenciador
		u1.setNome("Alberto Roberto de Oliveria");
		
		// 3. Estado DETACHED
		// objeto é desanexado do gerenciador
		// não será mais atulizado no banco!!
		em.detach(u1);
		
		// 4. Estado MANAGED
		// Objeto é reanexado ao gerenciador, porém uma nova instância é criada
		User uX = em.merge(u1);
		
		// 5. Estado DETACHED
		u1.setNome("Zé");
		
		// 6. Estado MANAGED
		uX.setNome("Alberto Roberto XXXXX");
		
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
