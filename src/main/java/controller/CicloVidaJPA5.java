package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.User;
import util.JpaUtil;

//<property name="hibernate.hbm2ddl.auto" value="update" />
public class CicloVidaJPA5 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();


		// 1. criamos uma TypedQuery
		TypedQuery<User> query = em.createQuery("from User", User.class);
		
		// 2. getResultList() retorna todos os usuário no estado MANAGED 
		List<User> lista = query.getResultList();
		
		// 3. altera o nome de cada usuário para maiúsculas
		lista.forEach(u -> u.setNome(u.getNome().toUpperCase()));
		
		tx.commit();
		
		em.close();
		JpaUtil.close();
	}

}
