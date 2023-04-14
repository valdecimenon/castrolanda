package classes.internas;


public class ClassseExterna1 {

	public static void main(String[] args) {
		new ClassseExterna1();
	}
	
	// construtor da classe
	public ClassseExterna1() {
		Interna ci = new Interna();
		System.out.println(ci.mensagem());
	}
	
	
	// declara uma classe interna
	class Interna {
		public String mensagem() {
			return "Texto da classe interna";
		}
		
	}
	
}
