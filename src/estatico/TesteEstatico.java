package estatico;

public class TesteEstatico {
	
	// dia da semana: 0=domingo, 1=segunda, etc
	enum DiaSemana {
		// 0      1         2
		DOMINGO, SEGUNDA, TERCA
	}

	private int a;  // 0
	
	public static void main(String[] args) {
		
		ClasseFilha.metodo();
		new TesteEstatico();
		DiaSemana dia = DiaSemana.TERCA;
	}
	
	
	// construtor da classe
	public TesteEstatico() {
		System.out.println("Construtor da classe");
		System.out.println("Valor a = " + a );
	}
	
	// inicializador não estático
	{
		System.out.println("Inicializador de objetos - 1");
	}
	
	// inicializador não estático
	{
		System.out.println("Inicializador de objetos - 2");
	}
	
	// inicializador não estático
	{
		System.out.println("Inicializador de objetos - 3");
		this.a = 2;
	}
	
	
	// inicializadores são executados antes do main!!!
	// inicializador estático
	static {
		System.out.println("Inicializador estatico 1");
	}
	
	// segundo inicializador estático
	static {
		System.out.println("Inicializador estatico 2");
		// sai do programa
		// System.exit(0);
	}
	
	// terceiro inicializador estático
	static {
		System.out.println("Inicializador estatico 3");
	}
	

	
	
}
