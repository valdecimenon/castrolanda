package exercicios;

import java.util.Scanner;

public class ExerJSE3 {

	public static void main(String[] args) {
//		Exercício JSE 3
//		Considerando os exercícios anteriores e, usando a classe Scanner:
//		1. Crie a entrada de dados, via teclado, para 3 produtos contendo o nome e o valor.
//		Ex.: Scanner teclado = new Scanner(System.in);
//		2. Mostre o valor total.
//		3. Mostre o pre�o m�dio.
		
		
		Produto p1 = lerProduto(1),
		  	    p2 = lerProduto(2),
		 	    p3 = lerProduto(3);

		float total = p1.getValor() + p2.getValor() + p3.getValor(),
		 	  precoMedio = total / 3.0f; 
		
		if (p1.getValor() < p2.getValor() && p1.getValor() < p3.getValor())
			System.out.println("Produto 1 tem o menor pre�o");
		else if (p2.getValor() < p3.getValor())
			System.out.println("Produto 2 tem o menor pre�o");
		else
			System.out.println("Produto 3 tem o menor pre�o");
		
		
		if (p1.getValor() > p2.getValor() && p1.getValor() > p3.getValor())
			System.out.println("Produto 1 tem o maior pre�o");
		else if (p2.getValor() > p3.getValor())
			System.out.println("Produto 2 tem o maior pre�o");
		else
			System.out.println("Produto 3 tem o maior pre�o");
		
		System.out.printf("\nValor total dos produtos: R$ %.2f", total);
		System.out.printf("\nPre�o m�dio dos produtos: R$ %.2f", precoMedio);
	}
	
	
	private static Produto lerProduto(int ordem) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("\nDigite o nome do produto %d:", ordem);
		String nome = teclado.nextLine();

		System.out.printf("\nDigite o valor do produto %d:", ordem);
		float valor = teclado.nextFloat();
		
		return new Produto(nome, valor);
	}

}
