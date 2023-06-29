package heranca.tabela_por_classe;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoPorClasse {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.set(2024, 6, 27);
		Date dataVenc = new Date(c.getTimeInMillis());

		
		Alimento tioJoao = new Alimento();
		tioJoao.setDescricao("Arroz Tio João");
		tioJoao.setUnidade(Unidade.KG);
		tioJoao.setPeso(new BigDecimal("5.0"));
		tioJoao.setVencimento(dataVenc);
		
		Medicamento dorflex = new Medicamento();
		dorflex.setDescricao("Analgésico Dorflex");
		dorflex.setUnidade(Unidade.COMPRIMIDOS);
		dorflex.setQuantidade(50);
		dorflex.setTarja(Tarja.SEM_TARJA);
		dorflex.setVencimento(dataVenc);
		
		Desodorante rexona = new Desodorante();
		rexona.setDescricao("Rexona men");
		rexona.setUnidade(Unidade.ML);
		rexona.setQuantidade(150);
		
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(tioJoao);
		em.persist(dorflex);
		em.persist(rexona);
		
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
