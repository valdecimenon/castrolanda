package sincronizacao.join;

public class MinhaThread extends Thread {

	private String nome;

	public MinhaThread(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {

		try {

			// executa 5X
			for (int i = 0; i < 5; i++) {

				System.out.println("\nRodando thread " + nome + " - contador = " + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nThread " + nome + " finalizou");
	}
}
