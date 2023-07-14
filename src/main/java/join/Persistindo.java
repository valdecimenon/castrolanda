package join;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class Persistindo {

	public static void main(String[] args) {
		Cliente rafael = new Cliente("Rafael");
		Pedido r1 = new Pedido(rafael, LocalDate.of(2023, 7, 10));
		Pedido r2 = new Pedido(rafael, LocalDate.of(2023, 7, 11));
		Pedido r3 = new Pedido(rafael, LocalDate.of(2023, 7, 12));
		rafael.setPedidos(List.of(r1, r2, r3));
		
		Cliente ariel = new Cliente("Ariel");
		Pedido a1 = new Pedido(ariel, LocalDate.of(2023, 7, 13));
		ariel.setPedidos(List.of(a1));
		
		Cliente muriel = new Cliente("Muriel");

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(rafael);
		em.persist(ariel);
		em.persist(muriel);

		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
