package sincronizacao.join;

// Exemplo de sincronização usando o método join()
public class ThreadLoop {

	public static void main(String[] args) {

		int tempo = 100;
		System.out.println("Thread que aguarda ela mesma!");

		try {

			// loop infinito
			for (;;) {
				System.out.println("\nEsperando " + tempo + " milissegundos...");
				// usa join para esperar até 100 ms
				Thread.currentThread().join(tempo);
				System.out.println("OK");
				tempo += 100;
				
//				if (tempo > 1000)
//					Thread.currentThread().interrupt();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nThread main finalizada");
	}

}
