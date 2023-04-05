package pacote1;

// classe filha de mamífero
// para que serve final?
final public class Cao extends Mamifero {

	public Cao(String especie) {
		super(especie);
	}
	
	public Cao(String especie, String nome) {
		super(especie, nome);
	}

	@Override
	public String toString() {
		return super.toString() + " Nome: " + getNome();
	}
	
	// qual a diferença entre sobrescrita e sobrecarga?
	public void latir() {
		System.out.println("AU AU AU");
	}
	
	// esta é uma sobrecarga de método
	// essa é a assinatura do método: void latir(String som)
	public void latir(String som) {
		System.out.println(som);
	}
	
}
