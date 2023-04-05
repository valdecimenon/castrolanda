package pacote1;

// classe filha de Animal
// e classe mae de cão
abstract public class Mamifero extends Animal {

	// construtor da classe Mamífero
	public Mamifero(String especie) {
		// chama o construtor da classe mãe
		// super() deve vir primeiro de tudo!!
		super(especie);
	}
	
	public Mamifero(String especie, String nome) {
		// chama o construtor da classe mãe
		// super() deve vir primeiro de tudo!!
		super(especie, nome);
	}
	
	// para que serve final?
	final public void mamar() {
		System.out.println("Mamando...");
	}
	
	// sobrescrita de método: sobrepoe o método da classe mãe
	@Override
	public void correr() {
		System.out.println("Mamifero correndo...");
	}
	
	// método herdado de Object: deve retornar uma String
	@Override
	public String toString() {
		return  "Espécie: " + getEspecie();
	}
	

}
