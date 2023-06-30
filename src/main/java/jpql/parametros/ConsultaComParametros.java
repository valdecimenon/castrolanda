package jpql.parametros;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpql.modelo.Famoso;
import util.JpaUtil;

/*
 * Temos dois tipos de parâmetros:
 * - Parametro nomeado
 * - Parâmetro posicional
 */
public class ConsultaComParametros {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		
		// Pârametros nomeados
		String jpql = "select f from Famoso f where f.nome = :nomePessoa or f.pais = :paisOrigem";
		
		TypedQuery<Famoso> query = em.createQuery(jpql, Famoso.class);
		query.setParameter("nomePessoa", "Bill Gates");
		query.setParameter("paisOrigem", "Brasil");
		query.getResultList().forEach(f -> System.out.println(f.getNome()));
		
		// *** continua
		
		em.close();
		JpaUtil.close();
	}

}
