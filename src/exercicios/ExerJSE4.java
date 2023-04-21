package exercicios;

import java.util.Scanner;

public class ExerJSE4 {
	
	// declara as variáveis sendo estáticas e podem ser acessadas por qualquer método estático da classe
	private static String arrNomes[] = null;
	private static float arrValores[] = null;

	public static void main(String[] args) {
//		Exercício JSE 4
//		Crie uma entrada de dados, via teclado, que possibilite:
//		1. Digitar a quantidade total de produtos a serem cadastrados.
//		2. Digitar o nome de cada produto, armazenado em um vetor do tipo String.
//		3. Digitar o valor de cada produto, armazenado em um vetor do tipo float.
//		4. Mostrar o valor total dos produtos.
//		5. Mostrar o preço médio dos produtos.
//		6. Mostrar o nome do produto de menor valor e seu preço.
//		7. Mostrar o nome do produto de maior valor e seu preço.
		
		Scanner teclado = new Scanner(System.in);
		
		// define o tamanho dos arrays
		System.out.println("\nQuantidade de produtos para cadastrar: ");
		int quantidade = teclado.nextInt();
		
		// instancia 2 arrays
		arrNomes = new String[quantidade];
		arrValores = new float[quantidade];
		
		// preenche os arrays
		for (int i=0; i<quantidade; i++) {
			lerProduto(i);
		}
		
		// percorre o vetor para buscar o menor e o maior valor
		float total = 0;
		
		String nomeMenorValor = arrNomes[0];
		float menorValor = arrValores[0];
		
		String nomeMaiorValor = arrNomes[0];
		float maiorValor = arrValores[0]; 
		
		for (int i=0; i<arrValores.length; i++) {
			total += arrValores[i];
			
			if (arrValores[i] < menorValor){
				menorValor = arrValores[i];
				nomeMenorValor = arrNomes[i];
			}
			
			if (arrValores[i] > maiorValor){
				maiorValor = arrValores[i];
				nomeMaiorValor = arrNomes[i];
			}
		}
		
		float precoMedio = total / arrValores.length;
		
		System.out.printf("\nValor total dos produtos: R$ %.2f", total);
		System.out.printf("\nPreço médio dos produtos: R$ %.2f", precoMedio);
		System.out.printf("\n%s tem o menor valor R$ %.2f", nomeMenorValor, menorValor);
		System.out.printf("\n%s tem o maior valor R$ %.2f", nomeMaiorValor, maiorValor);
	}
	
	private static void lerProduto(int indice) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("\nDigite o nome do produto %d:", indice + 1);
		arrNomes[indice] = teclado.nextLine();

		System.out.printf("\nDigite o valor do produto %d:", indice + 1);
		arrValores[indice] = teclado.nextFloat();
	}

}
