package enumeracao;

public class TesteLivro {

	public static void main(String[] args) {

		Livro java = Livro.JAVA;
		System.out.println(java);	
		
		Livro php = Livro.PHP;
		System.out.println(php);
			
		Livro c = Livro.C;
		System.out.println(c);

		System.out.println("================ Mostra todos os dados do enum ===============");
		for (Livro livro : Livro.values()) {
			System.out.println(livro);
		}
	}
	


}
