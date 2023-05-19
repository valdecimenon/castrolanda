package testes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.softgraf.agenda.dao.ConnectionFactory;
import com.softgraf.agenda.dao.Metadados;
import com.softgraf.agenda.dao.MySqlDataSource;

public class TesteMetadados {

	public static void main(String[] args) throws IOException, SQLException {
		
		MySqlDataSource ds = new MySqlDataSource();
		Connection connection = ConnectionFactory.getMysqlConnection(ds);
		Metadados m = new Metadados(connection);
		
		m.printDadosGerais();
		m.printListarTabelas();
		m.printDadosColunas("Contato");
		
		System.out.println("\nFechou a conexão");
		connection.close();
	}

}
