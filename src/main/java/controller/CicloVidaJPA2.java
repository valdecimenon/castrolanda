package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import util.JpaUtil;

// <property name="hibernate.hbm2ddl.auto" value="update" />
public class CicloVidaJPA2 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 1. Estado MANAGED
		// find() retorna uma instância de User a partir do gerenciador
		User u1 = em.find(User.class, 1L);
		
		// 2. Um objeto em estado MANAGED pode ser atualizado
		u1.setNome("Helena de Tróia");
		
		// 3. Estado NEW
		// criamos uma nova instância
		User u2 = new User("Alberto Roberto");
		
		// 4. Estado MANAGED
		// Objeto é anexado ao gerenciador, porém merge()
		// retorna uma nova referência (nova instancia)
		User uX = em.merge(u2);
		
		// 5. Mesmo conteúdo, porém objetos diferentes
		System.out.println(u2);
		System.out.println(uX);
		
		// 6. Somente o objeto em estado MANAGED será atualizado no gerenciador
		u2.setNome("Alberto Roberto u2");
		uX.setNome("Alberto Roberto uX");
		
		// 7. O conteúdo do gerenciador finalmente é sincronizado com o banco
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
