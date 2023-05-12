package com.softgraf.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Design Pattern: Fábrica de Conexões
public class ConnectionFactory {

	// este método "fabrica" uma conexão no padrão do MySQL
	// method factory
	public static Connection getMysqlConnection(MySqlDataSource ds) {
		Connection connection = null;

		try {

			Class.forName(ds.getClasse());
			System.out.println("Encontrou o drive de conexão");
			
			connection = DriverManager.getConnection(ds.getStringConexao(), ds.getUser(), ds.getPassword());
			System.out.println("Abriu a conexão");

		} catch (ClassNotFoundException e) {
			System.out.println("Conector java/mysql não encontrado");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Falha de conexão com o banco");
			e.printStackTrace();
		}
		
		return connection;
	}
}
