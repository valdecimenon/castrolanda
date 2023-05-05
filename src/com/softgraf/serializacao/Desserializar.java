package com.softgraf.serializacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Desserializar {

	public static void desserializar(String nomeArquivo) {

		try {
			FileInputStream arquivo = new FileInputStream(nomeArquivo);
			ObjectInputStream entrada = new ObjectInputStream(arquivo);
			
			// ClassNotFoundException
			 Object objeto = entrada.readObject();
			 
			 System.out.println("\nDados após desserialização...");
			 System.out.println(objeto);
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo " + nomeArquivo + " não encontrado");
			
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe Cliente não foi encontrada");
		}
	}
	
	public static void main(String[] args) {
		desserializar("cliente.ser");
		desserializar("repositorio_produtos.ser");
	}

}
