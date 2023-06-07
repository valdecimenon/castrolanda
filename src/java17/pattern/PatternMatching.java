package java17.pattern;

public class PatternMatching {

	public static void main(String[] args) {
		mensagem("Operação CONCLUIDA com sucesso!");
		mensagem(123);
		mensagem(null);
		mensagem(new StringBuilder("mensagem"));
		mensagem(new StringBuilder("mensagem do StringBuilder").toString());
		
		validar("Bem vindo ao Java");
		validar(null);
	}
	
	// pattern matching simplifica o uso de instanceof
	static void mensagem(Object msg) {
		if (msg instanceof String s) {
			System.out.println(s.toLowerCase());
		} else {
			System.out.println("Não é uma string");
		}
	}
	
	static void validar(Object obj) {
		if (obj instanceof String s && s.length() > 5) {
			System.out.println(s + " - é uma string válida");
		} else {
			System.out.println("String inválida");
		}
	}

}
