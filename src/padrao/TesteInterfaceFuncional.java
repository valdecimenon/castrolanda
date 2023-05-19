package padrao;

import java.util.List;

public class TesteInterfaceFuncional {

	public static void main(String[] args) {
		
		List<String> frutas = List.of("banana", "laranja", "uva", "kiwi");
		
		// usando classe anônima
		Impressao impA = new Impressao() {
			
			@Override
			public void imprimir(String msg) {
				System.out.println("AAAAAAAA");
			}
		};
	}

}
