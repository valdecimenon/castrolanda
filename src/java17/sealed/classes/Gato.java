package java17.sealed.classes;

//classe deve declar final, sealed ou non-sealed
public non-sealed class Gato extends Mamifero {

	@Override
	public void fazerBarulho() {
		System.out.println("MIAU MIAU");
	}

}
