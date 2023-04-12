package modificadores.pacote2;

import modificadores.pacote1.Animal;

public class TesteAnimal {

	public static void main(String[] args) {
		Animal animal = new Animal();
		// posso acessar diretamente do objeto Animal, somente o método público
		animal.metodoPublico();
		animal.a = 5;

		Gato gato = new Gato();
		gato.metodoPublico();
		gato.metodoProtected();

	}

}
