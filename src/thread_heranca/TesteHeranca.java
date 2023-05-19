package thread_heranca;

public class TesteHeranca {

	public static void main(String[] args) {
		Thread t1 = new ThreadHeranca();
		Thread t2 = new ThreadHeranca();
		Thread t3 = new ThreadHeranca();
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		
		t1.start();
		t2.start();
		t3.start();

	}

}
