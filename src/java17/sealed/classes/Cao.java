package java17.sealed.classes;

// classe deve declar final, sealed ou non-sealed
non-sealed public class Cao extends Mamifero {

	@Override
	public void fazerBarulho() {
		System.out.println("AU AU");
	}

}
