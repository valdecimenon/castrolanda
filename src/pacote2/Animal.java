package pacote2;

// classe abstrata Animal
abstract public class Animal {
	
	// campos
	private String tipoAnimal;
	private String raca;
	
	// construtor: ctrl 3 + gcuf
	public Animal(String tipoAnimal, String raca) {
		super();  // desnecessário, pois é implícito
		this.tipoAnimal = tipoAnimal;
		this.raca = raca;
	}
	
	// getters e setters: ctrl 3 + ggas
	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}


	// métodos de exibição de dados
	public void infoTipoAnimal() {
		System.out.printf("Animal: %s\n", tipoAnimal);
	}
	
	public void infoRaca() {
		System.out.printf("Raça: %s\n", raca);
	}
	
}
