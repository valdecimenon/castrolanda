package exercicios;

public class ExerJSE2 {

	public static void main(String[] args) {
//		Exercício JSE 2
//		Considerando o valor total dos mesmos produtos do exercício anterior e, sabendo que as formas de pagamento são:
//		- Á vista com 10% de desconto
//		- até 3X sem juros
//		- até 10X com 15% de acrescimo
//
//		Mostre:
//		1. o valor total
//		2. o valor total à vista
//		3. o valor de cada parcela para pagamento em 3X
//		4. o valor de cada parcela para pagamento em 10X
		
		float p1 = 9.99f,
		  	  p2 = 5.99f,
		 	  p3 = 1.99f,
		 	  total = p1 + p2 + p3,
		 	  aVista = total * 0.9f,
		 	  em3x = total / 3.0f,
		 	  em10x = total * 0.115f;
		 	  
		
		System.out.printf("\nValor total dos produtos: R$ %.2f", total);
		System.out.printf("\nValor total à vista: R$ %.2f", aVista);
		System.out.printf("\nValor de cada parcela em 3X sem juros: R$ %.2f", em3x);
		System.out.printf("\nValor de cada parcela em 10X com 15%% de acréscimo: R$ %.2f", em10x);
	}

}
