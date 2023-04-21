package estoque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

	private static InputStreamReader reader = new InputStreamReader(System.in);
	private static BufferedReader buffer = new BufferedReader(reader);
	
	public static String lerString(String msg) throws IOException {
		System.out.print(msg);
		return buffer.readLine();
	}

	public static int lerInteiro(String msg) throws NumberFormatException, IOException {
		return Integer.parseInt(lerString(msg));   // 
	}
	
	// se ocorrer, LANCE (throws) a Exceção
	public static float lerFloat(String msg) throws IOException {
		String numero = lerString(msg);   // "3,14" ou "3.14"
		if (numero.contains(",")) {
			numero = numero.replace(',', '.');
		}
		return Float.parseFloat(numero);
	}
	
}
