package classes.anonimas;

public class ClasseOutra {

	public static void main(String[] args) {
		// cria um objeto (radio) a partir de uma CLASSE ANÔNIMA que ESTENDE Radio
		Radio radio = new Radio() {
			public void ligar() {
				System.out.println("Radio ligado");
			};
		};
		
		radio.ligar();

	}

}
