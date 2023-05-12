package testes;

import java.io.IOException;

import com.softgraf.agenda.dao.MySqlDataSource;

public class TesteDao {

	public static void main(String[] args) throws IOException {
		
		MySqlDataSource ds = new MySqlDataSource();
		System.out.println(ds.getClasse());
		System.out.println(ds.getDatabase());
		System.out.println(ds.getDriver());
		System.out.println(ds.getUser());
		System.out.println(ds.getPassword());
		System.out.println(ds.getUrl());
		System.out.println(ds.getStringConexao());
		
	
	}

}
