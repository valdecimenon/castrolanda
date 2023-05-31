package daemon;

/*
 * O que é uma Thread Deamon?
 * 
 * - É uma thread de baixa prioridade que executa operações em segundo plano, como
 * coleta de lixo, finalizer, action listeners, eventos de GUI, provedor de serviços, etc.
 * 
 * - São interrompidas quando a thread principal, aquela que executa o método main,
 * termina de executar e o programa finaliza.
 * 
 * - Não são recomendadas para trabalhos críticos, pois estas poderão ser encerradas
 * a qualquer momento pela JVM, sem qualquer aviso.
 * 
 * - Se uma thread daemon cria outra thread, esta segunda será por padrão também uma
 * thread daemon (herança de propriedades).
 * 
 */

public class ExemploThreadDaemon {

	public static void main(String[] args) {

		Thread threadDaemon = new Thread(() -> {

			try {
				
				for (;;) {
					System.out.println("Executando threadDaemon...");
					Thread.sleep(1000);
				}
				
			} catch (InterruptedException e) {
				System.out.println("*** threadDaemon interrompida");
				
			} finally {
				System.out.println("*** threads daemon não executam o bloco finally quando encerradas pela JVM");
				// também não são recomendadas para serviços de I/O sem flush
			}
			
		});  // new Thread
		
		// aqui define que esta thread é do tipo Daemon
		threadDaemon.setDaemon(true);
	
		/*
		 * é recomendável que threads daemon tenham baixa prioridade para executarem sem "segundo plano"
		 */
		threadDaemon.setPriority(Thread.MIN_PRIORITY);
		System.out.println("====== Exemplo Thread Daemon =======");
		
		System.out.printf("\nthreadDaemon é uma thread daemon? %b - Prioridade = %d\n",
							threadDaemon.isDaemon(), threadDaemon.getPriority());

		
		System.out.printf("\nthread main é uma thread daemon? %b - Prioridade = %d\n",
				Thread.currentThread().isDaemon(), Thread.currentThread().getPriority());
		
		threadDaemon.start();
		
		
		for (int i=0; i<5; i++) {
			
			try {
				System.out.println("Executando thread main...");
				Thread.sleep(1000);
				
//				if (i == 3) threadDaemon.interrupt();
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("************* Thread main finalizou **************");
		// após main finalizar, threads do tipo daemon NÃO CONTINUARÃO EXECUTANDO
		
		
//		System.out.println(threadDaemon.isAlive());

	}

}
