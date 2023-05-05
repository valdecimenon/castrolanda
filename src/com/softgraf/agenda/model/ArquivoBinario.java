package com.softgraf.agenda.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Date;

// Gravação de dados binários
//
/*
 * Registro Contato:
 * cada registro de contato possui 64 bytes
 * int id + String nome + String fone
 * tamanho total: 4 + 40 + 20 = 64 bytes
 * int: 4 bytes
 * String: cada char = 2 bytes
 * - posição do ponteiro no arquivo: 
 * 0..63  = para o primeiro registro
 * 64..127 = para o segundo registro
 * etc
 * 
 * 1 João da Silva 42 3224-0123 2 Maria 42 3224-0000
 * 
 */

/**
 * <strong>Para ver o projeto completo acesse:</strong>
 * <a href="https://github.com/valdecimenon/castrolanda">Github Castrolanda</a>
 * 
 * @author Valdeci Menon
 * @version 1.0
 * @since 04-05-2023
 * 
 */
public class ArquivoBinario {

	// arquivo binário de acesso aleatório
	private RandomAccessFile arquivo;
	
	
	/**
	 * <p>Método responsável por abrir ou criar um arquivo binário de dados</p>
	 * @param nome É o arquivo a ser aberto ou criado.
	 * @see
	 * 		<a href="https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html">
	 * 			Retornando um valor de um método
	 * 	    </a>
	 * @since 1.0     
	 * @throws IOException Se não for possível abrir ou criar arquivo
	 *
	 */
	
	// método para abrir ou criar arquivo de dados. Ex: agenda.dat
	public void abrirArquivo(String nome) throws IOException {
		arquivo = new RandomAccessFile(nome, "rw");
		// posiciona o ponteiro no final do arquivo
		arquivo.seek(arquivo.length());
	}
	
	
	/**
	 * Fecha o arquivo
	 * @throws IOException Se não for possível fechar arquivo
	 */
	
	// fecha o arquivo de dados
	public void fecharArquivo() throws IOException {
		if (arquivo != null) {
			arquivo.close();
			arquivo = null;
		}
	}
	
	
	
	/**
	 * @deprecated talvez seja removido a partir da versão 2.0, use metodoNovo() ao invés desse
	 */
	public void metodoDepreciado() {
		
	}
	
	/**
	 * 
	 * @param contato É um objeto da classe Contato
	 * @see com.softgraf.agenda.model.Contato
	 * @throws IOException Se arquivo ainda não foi aberto
	 */
	
	// adiciona registro no final do arquivo
	public void gravarContato(Contato contato) throws IOException {
		// posiciona ponteiro no final do arquivo
		arquivo.seek(arquivo.length());
		// grava id
		arquivo.writeInt(contato.getId());
		// grava nome e fone, limitando o tamanho das strings
		arquivo.writeChars(limitarString(contato.getNome(), 20));
		arquivo.writeChars(limitarString(contato.getFone(), 10));
	}
	
	// limita o comprimento da String passada
	private String limitarString(String campo, int tamanhoMaximo) {
		StringBuilder sb = new StringBuilder(tamanhoMaximo);
		int diferenca = tamanhoMaximo - campo.length();   // nome = "joao"
		
		// faltam caracteres no tamanho do campo: então adiciona espaços
		if (diferenca > 0) {
			// arrChar = [0, 0, 0, 0, 0]
			char[] arrChar = new char[diferenca];
			Arrays.fill(arrChar, ' ');
			sb.append(campo);
			sb.append(arrChar);
		} else {
			sb.append(campo.substring(0, tamanhoMaximo));
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param numero É a posição do registro no arquivo: valor entre 1 e n
	 * @return Contato ou null
	 * @throws IOException Se o arquivo ainda não foi aberto
	 */
	
	// le um Contato, dado o número do registro
	// numero = 1..n
	public Contato lerContato(int numero) throws IOException {
		Contato contato = null;
		
		if (arquivo != null) {
			contato = new Contato();
			
			// calcula a posição absoluta para mover o ponteiro
			long posicao = (numero - 1) * 64;
			// posiciona o ponteiro
			arquivo.seek(posicao);
			
			// le id
			int id = arquivo.readInt();
			contato.setId(id);
			
			// le cada caractere do nome (20 vezes)
			StringBuilder nome = new StringBuilder(20);
			for (int i=0; i<20; i++) {
				nome.append(arquivo.readChar());
			}
			// trim = elimina todos os espaços do final da string
			contato.setNome(nome.toString().trim());
			
			// le cada caractere do fone (10 vezes)
			StringBuilder fone = new StringBuilder(10);
			for (int i=0; i<10; i++) {
				fone.append(arquivo.readChar());
			}
			// trim = elimina todos os espaços do final da string
			contato.setFone(fone.toString().trim());
		} else {
			// lance!!!
			throw new IOException("Nenhum arquivo aberto para leitura dos dados");
		}
		
		return contato;
	}
	
	/**
	 * @return int Retorna o total de registros existentes em agenda.dat
	 * @throws IOException Se o arquivo de dados ainda não está aberto
	 */
	
	// retorna a quantidade de registros do arquivo
	public int quantidadeRegistros() throws IOException {
		int quant = 0;
		
		if (arquivo != null) {
			quant = (int) arquivo.length() / 64;
		} else {
			throw new IOException("Nenhum arquivo aberto para leitura");
		}
		
		return quant;
	}
	
	
}
