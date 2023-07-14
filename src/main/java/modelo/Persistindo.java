package modelo;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class Persistindo {

	public static void main(String[] args) {
		Estudante rafael = new Estudante("Rafael", 15);
		Estudante gabriel = new Estudante("Gabriel", 18);
		Estudante ariel = new Estudante("Ariel", 20);
		Estudante jose = new Estudante("Jose", 33);
		Estudante maria = new Estudante("Maria", 43);
		
		Curso python = new Curso("Curso de Python", new BigDecimal("1299.99"));
		Curso js = new Curso("Curso de Javascript", new BigDecimal("1599.99"));
		Curso java = new Curso("Curso de Java", new BigDecimal("1999.99"));
		Curso fortran = new Curso("Curso de Fortran", new BigDecimal("2300.99"));
		
		rafael.matricular(python);
		rafael.matricular(js);
		rafael.matricular(java);
		
		gabriel.matricular(js);
		ariel.matricular(java);
		
		java.getEstudantes().forEach(System.out::println);
	/*	
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(rafael);
		em.persist(gabriel);
		em.persist(ariel);
		em.persist(jose);
		em.persist(maria);

		tx.commit();
		em.close();
		JpaUtil.close();
*/
	}
}
