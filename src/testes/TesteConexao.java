package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ATENÇÃO: module-info.java {
 *             requires java.sql;
 * 
 * Baixar conector java
 * softgraf.com/cursojava/drivers_jdbc
 * 
 * https://dev.mysql.com/downloads/connector/j/
 * Select Operating System: Plataform Independent
 */


// Caminho da classe principal do conector mysql/java
// com.mysql.cj.jdbc.Driver.class

/*
 * Usar banco mysql:
 * 
 * CREATE DATABASE agenda;
 * 
 * USE agenda;
 * 
 * CREATE TABLE contato (
 *    id INT PRIMARY KEY AUTO_INCREMENT,
 *    nome VARCHAR(60) NOT NULL,
 *    fone VARCHAR(14)
 * );
 * 
 * SHOW TABLES;
 * 
 * DESC agenda;
 * 
 */

public class TesteConexao {
	
	final private static String DRIVER =  "com.mysql.cj.jdbc.Driver";
	final private static String DATABASE = "agenda";
	//                            IP  "127.0.0.1:3306" ou "168.152.130.120:80"
	final private static String URL = "localhost:3306";
	final private static String STRCONEXAO = "jdbc:mysql://" + URL + "/" + DATABASE;
	final private static String USER = "root";          // usuário do banco (root é o padrao do mysql)
	final private static String PASSWORD = "softgraf";  // senha do banco

	public static void main(String[] args) {
		
		// primeiro devemos testar se o conector java/mysql está dispononível no projeto
		try {
			Class.forName(DRIVER);
			System.out.println("Encontrou o driver de conexão");
			
			Connection conexao = DriverManager.getConnection(STRCONEXAO, USER, PASSWORD);
			System.out.println("Abriu a conexão usando a url: \n" + STRCONEXAO );
			
			conexao.close();
			System.out.println("Fechou a conexão");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Conector java/mysql não encontrado!");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("Falha de conexão com o banco de dados");
			e.printStackTrace();
		}
	}

}
