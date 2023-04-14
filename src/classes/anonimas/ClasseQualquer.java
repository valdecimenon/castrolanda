package classes.anonimas;


public class ClasseQualquer {

	public static void main(String[] args) {
		// cria um objeto anônimo (sem variável) a partir de uma CLASSE ANÔNIMA (que estende Object)
		new Object() {
				// método
				public void fazerBarulho() {
					System.out.println("Au Au");
				}
		}.fazerBarulho();
	}
	
}
