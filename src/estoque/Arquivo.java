package estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;

import exercicios.Produto;

public class Arquivo {

	public static void gravarCSV(String arquivo, String[] arrTexto) throws IOException {
		
		FileWriter gravador = new FileWriter(arquivo);
		
		for (String linha : arrTexto) {
			gravador.write(linha);
			// mudança de linha no arquivo
			gravador.write("\r\n");
		}
		
		gravador.close();
	}
	
	public static Produto[] lerCSV(String arquivo) throws IOException {
		// le cada caractere do arquivo
		FileReader leitor = new FileReader(arquivo);
		// le cada linha do arquivo a partir do leitor
		BufferedReader buffer = new BufferedReader(leitor);
		// String é um objeto IMUTÁVEL portanto não devemos usar para juntar!!!
		// no lugar de String usamos StringBuilder
		StringBuilder stringBuilder = new StringBuilder();	
		
		while (buffer.ready()) {
			// "banana;1,99\nuva;3,99\nkiwi;19,99"
			stringBuilder.append(buffer.readLine()).append("\n");
		}
		
		buffer.close();
		leitor.close();
		
		// ["banana;1,99" "uva;3,99" "kiwi;19,99"]
		String[] linhas = stringBuilder.toString().split("\n");
		
		Produto[] array = new Produto[linhas.length];
		for (int i=0; i<linhas.length; i++) {
			String csv = linhas[i];
			Produto p = Produto.toProduto(csv);
			array[i] = p;
		}
		
		return array;
	}
}
