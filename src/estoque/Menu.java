package estoque;

import static java.lang.System.out;
import java.util.Scanner;

public class Menu {

	public static Opcao show() {
		
		Scanner teclado = new Scanner(System.in);
		int min = Opcao.SAIR.getCodMin();
		int max = Opcao.SAIR.getCodMax();

		out.println("\n\n======= Sistema de Estoque 0.1 =========");
		Opcao.LISTAR.imprimir();
		Opcao.INCLUIR.imprimir();
		Opcao.EXCLUIR.imprimir();
		Opcao.MOSTRAR_QUANT.imprimir();
		Opcao.MOSTRAR_VALOR.imprimir();
		Opcao.SALVAR_EXCEL.imprimir();
		Opcao.LER_EXCEL.imprimir();
		Opcao.SAIR.imprimir();
		
		
		int opcao = -1;
		do {
			out.println("Qual opção?");
			opcao = teclado.nextInt();
		} while (opcao < min || opcao > max);
		
		
		for (Opcao op : Opcao.values()) {
			if  (opcao == op.getCodigo()) {
				return op;
			}
		}
			
		return Opcao.SAIR;
	}
	
}
