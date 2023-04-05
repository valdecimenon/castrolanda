package pacote2;

// classe abstrata Humano
abstract public class Humano {

	private String sexo;

	// ctrl 3 + gcuf
	// construtor
	public Humano(String sexo) {
		super();  // desnecessário, pois é implícito
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void infoSexo() {
		System.out.printf("Sexo: %s\n", sexo);
	}
	

	
}
