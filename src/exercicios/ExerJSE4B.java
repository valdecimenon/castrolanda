package exercicios;

import java.util.Scanner;

public class ExerJSE4B {
	
	private static Produto arrProdutos[] = null;

	public static void main(String[] args) {
//		Idem ExerJSE4, porém usando um array de Produto
		
		Scanner teclado = new Scanner(System.in);
		
		// define o tamanho dos arrays
		System.out.println("\nQuantidade de produtos para cadastrar: ");
		int quantidade = teclado.nextInt();
		
		// se quantidade = 3 => arrProdutos = {null, null, null}
		arrProdutos = new Produto[quantidade];
		
		// preenche os arrays
		for (int i=0; i<quantidade; i++) {
			arrProdutos[i] = lerProduto(i);
		}
		
		// percorre o vetor para buscar o menor e o maior valor
		float total = 0;
		
		String nomeMenorValor = arrProdutos[0].getNome();
		float menorValor = arrProdutos[0].getValor();
		
		String nomeMaiorValor = arrProdutos[0].getNome();
		float maiorValor = arrProdutos[0].getValor(); 
		
		for (int i=0; i<arrProdutos.length; i++) {
			total += arrProdutos[i].getValor();
			
			if (arrProdutos[i].getValor() < menorValor){
				menorValor = arrProdutos[i].getValor();
				nomeMenorValor = arrProdutos[i].getNome();
			}
			
			if (arrProdutos[i].getValor() > maiorValor){
				maiorValor = arrProdutos[i].getValor();
				nomeMaiorValor = arrProdutos[i].getNome();
			}
		}
		
		float precoMedio = total / arrProdutos.length;
		
		System.out.printf("\nValor total dos produtos: R$ %.2f", total);
		System.out.printf("\nPreço médio dos produtos: R$ %.2f", precoMedio);
		System.out.printf("\n%s tem o menor valor R$ %.2f", nomeMenorValor, menorValor);
		System.out.printf("\n%s tem o maior valor R$ %.2f", nomeMaiorValor, maiorValor);
	}
	
	private static Produto lerProduto(int indice) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("\nDigite o nome do produto %d:", indice + 1);
		String nome = teclado.nextLine();

		System.out.printf("\nDigite o valor do produto %d:", indice + 1);
		float valor = teclado.nextFloat();
		
		return new Produto(nome, valor);
	}
}
