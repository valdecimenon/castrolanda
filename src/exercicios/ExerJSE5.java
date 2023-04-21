package exercicios;

public class ExerJSE5 {

	public static void main(String[] args) {
//		Exercício JSE 5
//		Um cliente fez um empréstimo de R$ 1.000,00. Sabendo-se que a taxa de juro é de 1% A.M.
//		Quero saber, após 60 meses qual será:
//		1. O total da dívida (capital + juros)
//		2. O valor total dos juros acumulados
//		3. O valor total de juros para uma taxa de 2% A.M.
		
		calcular(1000, 1.0f);
		calcular(1000, 2.0f);

	}
	
	private static void calcular(float emprestimo, float jurosAM) {
		float totalDivida = emprestimo;  
		// ex.: juros 1% = 1.01
		float juros = 1 + (jurosAM / 100.0f);  // 1.01
		
		for (int i=0; i<60; i++) {
			totalDivida *=  juros;
		}
		
		float totalJuros = totalDivida - emprestimo;
				
		System.out.printf("\n\nPara prazo de 60 meses, com juros de %.1f%%", jurosAM);
		System.out.printf("\nTotal da dívida: R$ %.2f", totalDivida);
		System.out.printf("\nTotal de juros acumulados: R$ %.2f", totalJuros);
	}

}
