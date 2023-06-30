package colecoes;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoSuco {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Suco s1 = new Suco();
		s1.setMarca("Campo Largo");
		List<String> sabores1 = Arrays.asList("uva", "laranja");
		s1.setSabores(sabores1);
		
		
		Suco s2 = new Suco();
		s2.setMarca("Del Valle");
		List<String> sabores2 = Arrays.asList("uva", "limão", "laranja", "abacaxi", "kiwi");
		s2.setSabores(sabores2);
		
		em.persist(s1);
		em.persist(s2);
		
		tx.commit();
		
		em.close();
		JpaUtil.close();

	}

}
