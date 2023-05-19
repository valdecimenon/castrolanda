package thread_implementacao;

public class TesteRunnable {

	public static void main(String[] args) {
		
		Runnable r = new ClasseRunnable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(() -> System.out.println("contar até 10"));
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
