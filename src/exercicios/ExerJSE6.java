package exercicios;

import java.util.Scanner;

public class ExerJSE6 {

	public static void main(String[] args) {
//		Exercício JSE 6
//		Com base no exercício anterior, crie uma entrada de dados via teclado, onde possamos digitar o valor das variáveis:
//		- valorEmprestimo
//		- jurosAM
//		- meses
//		Mostrando no final o valor total da dívida e o total de juros acumulados.
//		Obs.: Use Scanner teclado = new Scanner(System.in);
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("\nValor total do emprestimo:");
		float valorEmprestimo = teclado.nextFloat();
		
		System.out.println("\nTaxa de juros A.M.");
		float jurosAM = teclado.nextFloat();
		
		System.out.println("\nPrazo em meses para pagamento:");
		int meses = teclado.nextInt();
		
		calcular(valorEmprestimo, jurosAM, meses);
	}
	
	private static void calcular(float emprestimo, float jurosAM, int meses) {
		float totalDivida = emprestimo;  
		// ex.: juros 1% = 1.01
		float juros = 1 + (jurosAM / 100.0f);  // 1.01
		
		for (int i=0; i<meses; i++) {
			totalDivida *=  juros;
		}
		
		float totalJuros = totalDivida - emprestimo;
				
		System.out.printf("\n\nPara prazo de %d meses, com juros de %.1f%%", meses, jurosAM);
		System.out.printf("\nTotal da dívida: R$ %.2f", totalDivida);
		System.out.printf("\nTotal de juros acumulados: R$ %.2f", totalJuros);
	}

}
