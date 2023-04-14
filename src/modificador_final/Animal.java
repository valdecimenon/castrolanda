package modificador_final;

public class Animal {
	
	// define uma constante
	final private String som;

	public Animal(final String som) {		
		this.som = som;
	}
	
	public String getSom() {
		return som;
	}
}
