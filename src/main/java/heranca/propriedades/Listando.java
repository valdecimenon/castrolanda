package heranca.propriedades;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class Listando {

	public static void main(String[] args) {
			
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Medicamento>  medicamentos = em.createQuery("from Medicamento", Medicamento.class).getResultList();

		medicamentos.forEach(m -> System.out.printf("ID: %-5d Descrição: %-20s\n", m.getId(), m.getDescricao()));
	
	
		// como esse tipo de mapeamento não é uma estratégia de herança JPA,
		// não conseguimos fazer uma consulta polimórfica
		// QuerySyntaxException: Produto is not mapped
		List<Produto> produtos = em.createQuery("from Produto", Produto.class).getResultList();
	
		em.close();
		JpaUtil.close();
	}

}
