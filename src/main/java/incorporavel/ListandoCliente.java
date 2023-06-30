package incorporavel;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

public class ListandoCliente {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		
		clientes.forEach(c -> {
			System.out.println(c.getId());
			System.out.println(c.getNome());
			System.out.println(c.getEndereco().getRua());
			System.out.println(c.getEndereco().getCidade());
			System.out.println(c.getEndereco().getUf());
		});
		
		em.close();
		JpaUtil.close();
	}
}
