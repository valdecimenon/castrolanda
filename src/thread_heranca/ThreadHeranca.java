package thread_heranca;

/*
 * Thread atrav�s de heran�a:
 *   Estendemos a classe Thread e sobrescrevemos o m�todo run(), depois
 *   instanciamos um objeto e iniciamos a execu��o atrav�s do m�todo start()
 *   
 * Problema do uso de heran�a:
 *   Se precisarmos estender outra classe n�o podemos  
 *   
 * Principais m�todos herdados de Thread:
 * run() usado apenas para sobrescrita,, nunca deve ser chamado diretamente
 * start()  usado para executar o m�todo run()
 * sleep(milisegundos) suspende a Thread por um intevalo de tempo (InterruptedException)
 * setName() define o nome da Thread para determinada inst�ncia
 * currentThread() retorna o objeto da Thread que est� em execu��o no exato instante.
 * 
 * 
 * Lei de Moore
 * 
 * Lei de Andhal
 * 
 */

public class ThreadHeranca extends Thread {

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
