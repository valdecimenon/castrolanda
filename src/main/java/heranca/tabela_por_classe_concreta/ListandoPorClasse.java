package heranca.tabela_por_classe_concreta;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class ListandoPorClasse {

	public static void main(String[] args) {
			
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Medicamento>  medicamentos = em.createQuery("from Medicamento", Medicamento.class).getResultList();
		
		medicamentos.forEach(m -> System.out.printf("ID: %-5d Descrição: %-20s\n", m.getId(), m.getDescricao()));
		
		// vantagem da consulta polimórfica
		List<Produto> produtos = em.createQuery("from Produto", Produto.class).getResultList();
		
		produtos.forEach(p ->{
			
			if (p instanceof Alimento a) {
				System.out.printf("ID: %-5d Descrição: %-20s %s Kg\n", a.getId(), a.getDescricao(), a.getPeso());
				
			} else if (p instanceof Medicamento m) {
				System.out.printf("ID: %-5d Descrição: %-20s %s\n", m.getId(), m.getDescricao(), m.getTarja());
			}
		});
		

		em.close();
		JpaUtil.close();
	}

}
