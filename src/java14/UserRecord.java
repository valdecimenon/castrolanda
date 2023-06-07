package java14;

/*
 * Record pode ser usado como um DTO (Data Transfer Object)
 * Todos os campos de um record são implicitamente final
 * Define o nome do record e o seu construtor
 */
public record UserRecord(Long id, String nome, String senha) {

	// podemos declarar um campo estático
	public static String ROLE = "USER";
	
	// não é permitido declarar campo não estático
	// private String empresa;
	
	// Este é o Construtor Compacto (opcional)
	public UserRecord {
		System.out.println("Chamou o construtor compacto");
	}
	
	// construtor com 2 argumentos (opcional)
	public UserRecord(Long id, String nome) {
		this(id, nome, "");
	}
	
	// método personalizado
	public void info() {
		System.out.println("Id: " + id + "\nNome: " + nome);
	}
	
	// não é permitido alterar um campo de um Record,
	// pois eles são "somente leitura" = final
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
}
