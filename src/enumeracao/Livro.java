package enumeracao;

public enum Livro {

	// declaração de constantes
	JAVA("Java como programar", "Deitel", 1),
	PHP("PHP A Bíblia", "Tim", 2),
	C("C Completo e Total", "Schildt", 3);
	
	// definição das constantes
	final private String titulo;
	final private String autor;
	final private int codigo;
	
	// método de definição das constantes
	private Livro(String titulo, String autor, int codigo) {
		this.titulo = titulo;
		this.autor = autor;
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %d", getTitulo(), getAutor(), getCodigo());
	}
}
