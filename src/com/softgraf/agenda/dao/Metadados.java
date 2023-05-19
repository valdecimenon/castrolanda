package com.softgraf.agenda.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.lang.System.out;

public class Metadados {

	private DatabaseMetaData metadados;

	public Metadados(Connection conexao) throws SQLException {
		this.metadados = conexao.getMetaData();
	}

	public void printDadosGerais() {
		System.out.println("\n===== Metadados gerais do MySQL");

			try {
				out.println("Banco: " + metadados.getDatabaseProductName());
				out.println("Versão: " + metadados.getDatabaseProductVersion());
				out.println("Nome do usuário logado: " + metadados.getUserName());
				out.println("Nome do driver: " + metadados.getDriverName());
				out.println("Versão do driver: " + metadados.getDriverVersion());
				
			} catch (SQLException e) {
				out.println("Erro em printDadosGerais");
				e.printStackTrace();
			}
	}

	public void printListarTabelas() {
		System.out.println("\n===== Todas as tabelas do MySQL");
		
		String tipos[] = {"TABLE"};
		try {
			ResultSet rs = metadados.getTables(null, null, null, tipos);
			
			while (rs.next()) {
				String nome = rs.getString("TABLE_NAME");
				System.out.println(nome);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro em printDadosTabelas()");
			e.printStackTrace();
		}
	}

	public void printDadosColunas(String tableName) {
		System.out.println("\n===== Dados das colunas da tabela " + tableName);
		
		try {
			ResultSet rs = metadados.getColumns(null, null, tableName, null);
			
			while (rs.next()) {
				String col = rs.getString("COLUMN_NAME");
				String tipo = rs.getString("TYPE_NAME");
				String tam = rs.getString("COLUMN_SIZE");
				System.out.printf("Coluna: %-20s Tipo: %-10s Tamanho: %-10s\n", col, tipo, tam);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro em  printDadosColunas()");
			e.printStackTrace();
		}
	}

}










