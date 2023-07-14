package join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

/*
 * em uma consulta podemos usar:
 * - ponto: quando o relacionamento for 1:1 ou *:1
 * - [inner] join: quando o relacionamento for 1:* ou *:*
 *   pega duas entidades e retorna somente o que há em comum nas duas. 
 */

public class Consultando {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		System.out.println("\n--- Todos os clientes");
		TypedQuery<Cliente> query1 = em.createQuery("from Cliente", Cliente.class);
		query1.getResultList().forEach(System.out::println);
		
		// usando ponto - consulta fazendo navegação: Pedido (muitos) -> Cliente (um)
		System.out.println("\n--- Com operador ponto: Todos os pedidos do cliente Rafael");
		TypedQuery<Pedido> query2 = em.createQuery("select p from Pedido p where p.cliente.nome = 'Rafael'", Pedido.class);
		query2.getResultList().forEach(System.out::println);
		
		// usando inner join - consulta fazendo navegação: Pedido (muitos) -> Cliente (um)
		System.out.println("\n--- Com opereador inner join - *:1 : Todos os pedidos do Rafael");
		TypedQuery<Pedido> query3 = em.createQuery("select p from Pedido p inner join p.cliente c where c.nome = 'Rafael'", Pedido.class);
		query3.getResultList().forEach(System.out::println);
		
		// usando inner join - consulta fazendo navegação: Cliente (um) -> Pedido (muitos)
		// essa navegação não seria possível sem joinm pois c.pedidos reteornaria uma lista!
		System.out.println("\n--- Com opereador inner join - 1:* : Todos os pedidos do Rafael");
		TypedQuery<Pedido> query4 = em.createQuery("SELECT p FROM Cliente c JOIN c.pedidos p WHERE c.nome = 'Rafael' ", Pedido.class);
		query4.getResultList().forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}
}
