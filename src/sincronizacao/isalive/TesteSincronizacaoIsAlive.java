package sincronizacao.isalive;

public class TesteSincronizacaoIsAlive {

	public static void main(String[] args) {
		Thread t1 = new MinhaThread("T1");
		Thread t2 = new MinhaThread("T2");
		Thread t3 = new MinhaThread("T3");
		
		System.out.println("\nIniciando threads....");
		t1.start();
		t2.start();
		t3.start();
		
		// deixa a Thread main em loop até as outras finalizarem
		do {
			System.out.print(".");
			
			try {
				// dorme 0,1 segundos para executar as threads t1, t2, t3
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} while (t1.isAlive() || t2.isAlive() || t3.isAlive());
		
		// uma thread morta não pode mais ser executada
		// java.lang.IllegalThreadStateException
		// t1.start();
		
		System.out.println("\n\nThread T1 está viva?" + t1.isAlive());
		System.out.println("\nNome da Thread atual = " + Thread.currentThread().getName());
		System.out.println("\n\nThread  main está viva?" + Thread.currentThread().isAlive());
		System.out.println("\nThread main finalizou ->  está morta");
	}
}
