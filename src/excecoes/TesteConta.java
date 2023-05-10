package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static java.lang.System.err;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta contaJoao = new Conta("João da Silva", 1000);
		Scanner teclado = new Scanner(System.in);
		
		
		try {
			FileOutputStream errorLog = new FileOutputStream("error.log", true);
			System.setErr(new ErrorPrintStream(errorLog));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
		out.println("Depositando R$ 200,00");
		contaJoao.depositar(200);
		out.println(contaJoao);
		
		try {
		
			out.println("Valor do saque: ");
			double saque = teclado.nextDouble();
			contaJoao.sacar(saque);
			
			out.println("fim do try");

		} catch (InputMismatchException e) {
			err.println("Valor digitado deve ser um número");
			
		} catch (ContaRuntimeException e) {
			err.println(e.getMessage());
			
		} finally {
			out.println("Executou finally");
		}
			
		
		out.println(contaJoao);
	}

}
