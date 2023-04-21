package exercicios;

public class ExerJSE1 {

	public static void main(String[] args) {
//		Exercício JSE 1
//		Dados 3 produtos quaisquer, mostre:
//		1. qual tem o menor preço?
//		2. qual tem o maior preço?
//		3. qual o valor total dos produtos?
//		4. qual o preço médio dos produtos?
		
		float p1 = 9.99f,
		  	  p2 = 5.99f,
		 	  p3 = 1.99f,
		 	  total = p1 + p2 + p3,
		 	  precoMedio = total / 3.0f; 
		
		if (p1 < p2 && p1 < p3)
			System.out.println("Produto 1 tem o menor preço");
		else if (p2 < p3)
			System.out.println("Produto 2 tem o menor preço");
		else
			System.out.println("Produto 3 tem o menor preço");
		
		
		if (p1 > p2 && p1 > p3)
			System.out.println("Produto 1 tem o maior preço");
		else if (p2 > p3)
			System.out.println("Produto 2 tem o maior preço");
		else
			System.out.println("Produto 3 tem o maior preço");
		
		System.out.printf("\nValor total dos produtos: R$ %.2f", total);
		System.out.printf("\nPreço médio dos produtos: R$ %.2f", precoMedio);

	}

}
