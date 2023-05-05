package com.softgraf.serializacao;
/*
 * Serialização é o processo pelo qual convertemos um objeto java em um sequência de bits
 * Depois podemos:
 * - gravar em disco
 * - enviar por rede, via socket
 * E depois recuperar (desserializar) este objeto
 * 
 * Para que um objeto seja serializado, deve implementar a interface Serializable,
 * que não possui nenhum método a ser implementado!
 * Uma interface que não possui métodos é chamada de: INTERFACE DE MARCAÇÃO
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializar {

	
	public static void serializar(Serializable objeto, String nomeArquivo) {

		try {
			// o objeto serializado deve ser gravado em um arquivo de fluxo de bytes (Stream)
			FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
			// classe para serializar o objeto
			ObjectOutputStream saida = new ObjectOutputStream(arquivo);
			
			saida.writeObject(objeto);
			saida.close();
			System.out.println("Objeto serializado com sucesso em " + nomeArquivo);
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro em FileOutputStream");
			
		} catch (IOException e) {
			System.out.println("Erro em ObjectOutputStream");
		}
	}
	
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("João da Silva");
		cliente.setFone("(42) 3224-1234");
		cliente.setSaldo(1200);
		serializar(cliente, "cliente.ser");
		
		Produto p1 = new Produto();
		p1.setId(1);
		p1.setDescricao("TV LG 50");
		
		Produto p2 = new Produto();
		p2.setId(2);
		p2.setDescricao("Celular");
		
		RepositorioProdutos repositorio = new RepositorioProdutos();
		repositorio.add(p1);
		repositorio.add(p2);
		serializar(repositorio, "repositorio_produtos.ser");
	}

}
