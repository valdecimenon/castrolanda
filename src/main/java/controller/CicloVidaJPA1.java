package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import util.JpaUtil;


// <property name="hibernate.hbm2ddl.auto" value="create" />
public class CicloVidaJPA1 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 1. Estado NEW
		// Objeto ainda não foi passado para o gerenciador (entity manager)
		User u1 = new User("Manoel Gomes");   // ref: entities.User@4d266391
		User u2 = new User("Adolfo Rodolfo");
		System.out.println(u1);
		
		// 2. Estado MANAGED
		// Objeto foi passado para o gerenciador
		// a referência interna no gerenciador é a mesma
		em.persist(u1);
		em.persist(u2);   // persist não altera a referência
		
		// 3. Um objeto em estado MANAGED pode ser atualizado
		u1.setNome("Gabriela Pires");
		
		// 4. Estado REMOVED
		// Objeto foi removido do gerenciador, não será salvo 
		// e se existir no banco será deletado
		em.remove(u2);
		
		// 5. O conteúdo do gerenciador é sincronizado com o banco
		// nesse caso somente user1 será gravado
		tx.commit();
		
		
		em.close();
		JpaUtil.close();
	}

}
