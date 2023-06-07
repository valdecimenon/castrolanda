package java12;

public class StringNovosMetodos {

	public static void main(String[] args) {
		// método para criar identação
		String texto = "Novo método para identação\ndo java 12".indent(7);
		System.out.println(texto);
		
		// método para receber uma função ou lambda
		String resultado = "João "
				.transform(s -> s + " da Silva")
				.transform(String::toUpperCase);
		System.out.println(resultado);
	}

}
