package trycatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Fechamento autom�tico de arquivo (somente a partir do Java 7)
 * Podemos usar apenas com classes que implementam a interface 
 * AutoCloseable (herdada por java.io.Closeable)
 * Classes que implementam: InputStream, OutputStream e suclasses.
 */
public class ExemploTryWithResources {

	public static void main(String[] args) {
		
		String origem = "e:/texto_origem.txt";
		String destino = "e:/texto_destino.txt";
		int v;
		
		// As vari�veis entrada e saida s�o locais ao bloco try e implicitamente final
		// Ex: final FileInputSream ...
		// Podemos incluir mais de um recurso (vari�vel) em um bloco try
		try (FileInputStream entrada = new FileInputStream(origem);
			 FileOutputStream saida = new FileOutputStream(destino);	
			) {
			
			
			System.out.println("\nConte�do do arquivo:");
			do {
				v = entrada.read();  // l� um caractere por vez como inteiro
				// verifica se chegou no final do arquivo
				if (v != -1) {
					System.out.print((char) v);
					saida.write(v);
				}
			} while(v != -1);
			System.out.println("\nArquivo copiado!");
			// Ao finalizar o bloco try os arquivos ser�o automaticamente fechados,
			// atrav�s de uma chamada ao m�todo close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
