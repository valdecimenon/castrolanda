package estoque;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import exercicios.Produto;

public class ExerJSE8 {

	// tamanhho = 10
	// posicao = 0 1 2 3 4 5 6 7 8 9
	// arrEstoque = [obj0 obj2 obj3 obj4 null null null null null null]
	private static Produto[] arrEstoque = null;
	private static int posicao = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int tamanho = Teclado.lerInteiro("\nTamanho do estoque: ");
		arrEstoque = new Produto[tamanho];
		Opcao opcao;

		do {

			opcao = Menu.show();

			switch (opcao) {

			case INCLUIR:
				incluir();
				break;

			case EXCLUIR:
				excluir();
				break;

			case LISTAR:
				listar();
				break;

			case MOSTRAR_QUANT:
				System.out.printf("\nTotal de produtos no estoque: %d", posicao);
				break;

			case MOSTRAR_VALOR:
				totalEstoque();
				break;

			case SALVAR_EXCEL:
				salvarExcel();
				break;

			case LER_EXCEL:
				lerExcel();
				break;

			case SAIR:
				System.out.println("\nAdeus!");
				break;

			default:
				System.out.println("\nOpção inválida!");

			}

		} while (opcao != Opcao.SAIR);
	}

	private static void lerExcel() throws IOException {
		File file = new File("estoque.csv");
		if (file.exists()) {
			arrEstoque = Arquivo.lerCSV("estoque.csv");
			posicao = arrEstoque.length;
			System.out.println("\nCSV carregado com sucesso!");
			
		} else {
			System.out.println("Não existe arquivo estoque.csv");
		}
		
	}

	private static void salvarExcel() throws IOException {
		if (posicao > 0) {

			String arrTexto[] = new String[posicao];

			for (int i = 0; i < posicao; i++) {
				Produto p = arrEstoque[i];
				// ex: ["banana;1,99" "laranja;5,99" "uva15,99"]
				arrTexto[i] = p.toCSV();
			}

			Arquivo.gravarCSV("estoque.csv", arrTexto);
			System.out.println("\n\nSalvou como: estoque.csv");
			
		} else {
			System.out.println("\n\nEstoque está vazio!");
		}

	}

	private static void totalEstoque() {
		float total = 0;
		for (Produto p : arrEstoque) {
			total += p == null ? 0 : p.getValor();
		}

		System.out.printf("\n\nValor total do estoque = R$ %.2f", total);
	}

	private static void excluir() throws IOException {
		String nome = Teclado.lerString("Nome do produto para excluir: ");
		boolean apagou = false;

		for (int i = 0; i < arrEstoque.length; i++) {
			Produto p = arrEstoque[i];
			if (p != null && p.getNome().equalsIgnoreCase(nome)) {
				arrEstoque[i] = null;
				apagou = true;
				relocarArray(i);
				posicao--;
				break;
			}
		}

		System.out.println(apagou ? "Produto deletado!" : "Produto não encontrado!");
		System.out.println(Arrays.toString(arrEstoque));
	}

	// move todos os elementos do array uma posição para a esquerda,
	// fechando assim o "buraco" do objeto excluido
	private static void relocarArray(int inicio) {
		for (int i = inicio; i < arrEstoque.length; i++) {
			// se for última posição: depois da última não tem nada!
			if (i + 1 == arrEstoque.length)
				arrEstoque[i] = null;
			else
				arrEstoque[i] = arrEstoque[i + 1];
		}

	}

	private static void listar() {
		if (posicao == 0) {
			System.out.println("\nNão há produtos cadastrados");
			return;
		}

		System.out.println("\n\n===== Listando todos os produtos do estoque ======");
		for (Produto produto : arrEstoque) {
			if (produto != null) {
				System.out.println(produto);
			}

		}

//		System.out.println("\n" +  Arrays.toString(arrEstoque));
	}

	private static void incluir() throws IOException {
		if (posicao < arrEstoque.length) {
			Produto p = new Produto();
			p.setNome(Teclado.lerString("\n>>Nome do produto: "));
			p.setValor(Teclado.lerFloat("\n>>Valor do produto: "));
			arrEstoque[posicao] = p;
			System.out.printf("Produto cadastrado na posição %d do estoque", posicao);
			posicao++;
		} else {
			System.out.printf("Não há mais espaço no array estoque!");
		}

//		System.out.println("\n" +  Arrays.toString(arrEstoque));

	}

}
