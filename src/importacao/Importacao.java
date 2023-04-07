package importacao;

// importação estática
import static java.lang.System.out;

import java.io.PrintStream;
// ctrl shift o
import java.util.Scanner;

public class Importacao {

	public static void main(String[] args) {
		// Scanner importado       Scanner referenciando o pacote
		Scanner teclado = new java.util.Scanner(System.in);

		out.println("Digite um inteiro: ");
		int valor = teclado.nextInt();

		PrintStream s = System.out;
		s.println("Saida com PrintStream");
	}

}

// println("intervalo coffee...")
