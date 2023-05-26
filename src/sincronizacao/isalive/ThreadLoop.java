package sincronizacao.isalive;

public class ThreadLoop {

	public static void main(String[] args) {
		int i =0;
		System.out.println("Thread: " + Thread.currentThread().getName());
		
		do {
			
			
			try {
			    System.out.println("i=" + i++);
				// dorme 1 segundo
				Thread.sleep(1000);
				
				if (i > 5)
					// lança a excessão
					// interrupt() simplesmente acorda a Thread, porém não finaliza!
					Thread.currentThread().interrupt();
				    // mata a thread
//					Thread.currentThread().stop();
				
				
				
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida");
				if (i > 15) break;
			}
			
		} while (Thread.currentThread().isAlive());
		
		System.out.println("Fim da Thread main");

	}

}
