package objetos_grandes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) throws IOException {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Veiculo v = new Veiculo();
		v.setMarca("VW");
		v.setModelo("Polo");
		v.setDescricao("""
It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.
The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using
'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors
now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their
infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose 
(injected humour and the like).
					""");
		
		Path path = FileSystems.getDefault().getPath("e:/polo.jpg");
		byte[] foto = Files.readAllBytes(path);
		v.setFoto(foto);
		
		em.persist(v);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
