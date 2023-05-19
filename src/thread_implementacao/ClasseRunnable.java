package thread_implementacao;

/*
 * Thread através de implementação:
 * 
 *    Implementamos a interface Runnable e sobrescrevemos o método run()
 *    Depois instanciamos a classe Thread e passamos este objeto
 */

public class ClasseRunnable implements Runnable {

	@Override
	public void run() {

		String nome = Thread.currentThread().getName();

		try {

			for (int i = 0; i < 10; i++) {
				System.out.println("Thread: " + nome + " : " + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Fim Thread " + nome);
	}

}
