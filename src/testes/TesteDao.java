package testes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import com.softgraf.agenda.dao.ConnectionFactory;
import com.softgraf.agenda.dao.ContatoRepository;
import com.softgraf.agenda.dao.MySqlDataSource;
import com.softgraf.agenda.model.Contato;

public class TesteDao {

	public static void main(String[] args) throws IOException, SQLException {
		
		MySqlDataSource ds = new MySqlDataSource();
		System.out.println(ds.getClasse());
		System.out.println(ds.getDatabase());
		System.out.println(ds.getDriver());
		System.out.println(ds.getUser());
		System.out.println(ds.getPassword());
		System.out.println(ds.getUrl());
		System.out.println(ds.getStringConexao());
		
		Connection conexao = ConnectionFactory.getMysqlConnection(ds);
		ContatoRepository repository = new ContatoRepository(conexao);
		
		// teste método save
//		Contato c1 = new Contato("Luiz Carlos", "(42)98402-1234");
//		boolean r1 = repository.save(c1);
//		System.out.println("\nsave() = " + r1);
		
//		System.out.println("\nfindById()");
//		Contato contato = repository.findById(1L);
//		if (contato != null) {
//			System.out.println(contato);
//		}
//
//		System.out.println("\nfindAll()");
//		List<Contato> lista = repository.findAll();
//		// lambda
////		lista.forEach(c -> System.out.println(c)); 
//		// method reference
//		lista.forEach(System.out::println); 
//	
//		
//		System.out.println("\ndelete()");
//		repository.delete(3L);
//		
//		System.out.println("\nexisteById()");
//		boolean existe = repository.existsById(99L);
//		System.out.println(existe);
//		
//		
//		System.out.println("Atualizando contato");
//		Contato c2 = repository.findById(2L);
//		c2.setNome("Maria Luiza");
//		c2.setFone("(42)3333-4444");
//		repository.update(2L, c2);
//		
//		long quant = repository.count();
//		System.out.println("\ncount() = " + quant);
//		
//		int total = repository.storeProcedureTotalContatos();
//		System.out.println("\nRetorno store procedure: " + total);
		
		// teste paginação
		List<Contato> pagina;
		
		System.out.println("\n==== Teste paginação tamanho 5");
		do {
			pagina = repository.next();
			System.out.printf("\n=== Página: %d   Tamanho: %d\n", repository.getPageNumber(), repository.getPageSize());
			pagina.forEach(System.out::println);  //:: method reference
			
		} while (!pagina.isEmpty());
		
		repository.first();
		repository.setPageSize(10);
		pagina = repository.next();
		System.out.printf("\n=== Página: %d   Tamanho: %d\n", repository.getPageNumber(), repository.getPageSize());
		pagina.forEach(System.out::println);
		
		
		conexao.close();
		System.out.println("Fechou a conexão");
	}

}
