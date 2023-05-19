package thread_heranca;

/*
 * Thread através de herança:
 *   Estendemos a classe Thread e sobrescrevemos o método run(), depois
 *   instanciamos um objeto e iniciamos a execução através do método start()
 *   
 * Problema do uso de herança:
 *   Se precisarmos estender outra classe não podemos  
 *   
 * Principais métodos herdados de Thread:
 * run() usado apenas para sobrescrita,, nunca deve ser chamado diretamente
 * start()  usado para executar o método run()
 * sleep(milisegundos) suspende a Thread por um intevalo de tempo (InterruptedException)
 * setName() define o nome da Thread para determinada instância
 * currentThread() retorna o objeto da Thread que está em execução no exato instante.
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
