package pacote1;


// classe mãe 
// classe abstrata não pode ser instanciada
abstract public class Animal  {  // extends Object

	
	
	// atributos ou variáveis da classe
	// ou campos do objeto
	private String especie;
	private String nome;
	private Integer peso;

	// construtor padrão: sempre deve existir um
	public Animal() {
		
	}
	
	
	// shading: o parâmetro especie faz sobreamento sobre o campo espécie
	// consturores da classe
	public Animal(String especie) {
		this(especie, null);
	}

	// um construtor chama o outro, para não repetir código
	public Animal(String especie, String nome) {
		this(especie, nome, null);
	}
	
	public Animal(String especie, String nome, Integer peso) {
		this.especie = especie;
		this.nome = nome;
		this.peso = peso;
	}
	

	// getters e setters
	// baseado no tipo da variável da classe
	// get deve retornar o mesmo tipo
	public String getEspecie() {
		return especie;
	}


	// set deve ter um parâmetro e nada retornar (void)
	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getNome() {
		return nome;
	}


	public Integer getPeso() {
		return peso;
	}
	
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	public void correr() {
		System.out.println("Animal correndo...");
	}

}
