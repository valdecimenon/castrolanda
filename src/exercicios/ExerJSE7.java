package exercicios;

import java.util.Scanner;

public class ExerJSE7 {

	public static void main(String[] args) {
//		Exercício JSE 7
//		1. Crie a classe Produto contendo os atributos: nome e valor.
//		2. Crie um vetor do tipo Produto chamado estoque.
//		  Ex.: Produto[] estoque = new Produto[quantidade]
//		3. A quantidade do estoque deve ser informada via teclado.
//		4. Você deve cadastrar todos os produtos do estoque (quantidade).
//		  Obs.: Use o loop for para percorrer o vetor.
//		5. No final liste em uma coluna o nome e na outra os valores.
//		6. No final da listagem deve aparece o valor total.
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nQuantidade de produtos para cadastrar no estoque:");
		int quantidade = teclado.nextInt();
		
		Produto[] estoque = new Produto[quantidade];
		
		for (int i=0; i<estoque.length; i++) {
			lerProduto(estoque, i);
		}
		
		float total = 0;
		for (Produto produto : estoque) {
			System.out.println(produto);
			total += produto.getValor();
		}
		
		System.out.printf("\nTotal dos produtos R$ %.2f", total);
	}
	
	
	private static void lerProduto(Produto[] estoque, int indice) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("\nDigite o nome do produto %d:", indice + 1);
		String nome = teclado.nextLine();

		System.out.printf("\nDigite o valor do produto %d:", indice + 1);
		float valor = teclado.nextFloat();
		
		estoque[indice] = new Produto(nome, valor);
	}

}
