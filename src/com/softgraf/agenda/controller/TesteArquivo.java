package com.softgraf.agenda.controller;

import java.io.IOException;

import com.softgraf.agenda.model.ArquivoBinario;
import com.softgraf.agenda.model.Contato;

public class TesteArquivo {

	public static void main(String[] args) {
		Contato c1 = new Contato(1, "João da Silva", "3224-0705");
		Contato c2 = new Contato(2, "Josiel Madureira", "3224-1234");
		Contato c3 = new Contato(3, "Maria Luiza", "3028-1234");
		Contato c4 = new Contato(4, "JRafael Moreira", "98401-0000");	
		
		ArquivoBinario arq = new ArquivoBinario();
		
		System.out.println("Salvando registros...");
		
		try {
			arq.abrirArquivo("agenda.dat");
			System.out.println("Abriu arquivo de dados");
			arq.gravarContato(c1);
			arq.gravarContato(c2);
			arq.gravarContato(c3);
			arq.gravarContato(c4);
		
			
			Contato c = arq.lerContato(1);
			System.out.println(c);
			
			int quant = arq.quantidadeRegistros();
			System.out.println("Total de registros: " + quant);

			
		} catch (IOException e) {		
			e.printStackTrace();

		// => tente executar o try
		// => se ocorrer alguma excessão -> agarre a excessão = catch
		// finalmente faça o finally (sempre executa)
		} finally {
			System.out.println("Executou finally");
			
			try {
				System.out.println("Fechou arquivo");
				arq.fecharArquivo();
				
			} catch (IOException e) {
				System.out.println("Não fechou o arquivo");
			}
			
		}

	}

}
