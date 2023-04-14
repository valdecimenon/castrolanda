package classes.abstratas;

// uma classe abastrata pode conter método abstratos e/ou concretos
abstract public class Animal {

	// método concreto
	public void dormir() {
		System.out.println("Animal dormindo");
	}
	
	// métodos abstratos => devem ser implementados pela classe final
	abstract public void comer();
	
	abstract public void deslocar();
	
}
