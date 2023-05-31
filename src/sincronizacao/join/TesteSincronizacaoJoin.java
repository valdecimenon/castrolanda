package sincronizacao.join;

public class TesteSincronizacaoJoin {

	public static void main(String[] args) {
		Thread t1 = new MinhaThread("T1");
		Thread t2 = new MinhaThread("T2");
		Thread t3 = new MinhaThread("T3");
		
		System.out.println("\nIniciando threads...");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			// Note que a execução de main() para aqui até t1 finalizar
			System.out.println("\nt1.join()");
			t1.join(); 
			System.out.println("\nOK T1 joined!");
			
			// depois que t1 finalizar, main espera t2, caso não tenha ainda finalizado
			System.out.println("\nt2.join()");
			t2.join(); 
			System.out.println("\nOK T2 joined!");
			
			// depois que t2 finalizar, main espera t3, caso não tenha ainda finalizado
			System.out.println("\nt3.join()");
			t3.join(); 
			System.out.println("\nOK T3 joined!");
		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n\nT1, T2 e T3 finalizaram");
		
		System.out.println("Encerrou a thread do main");
	}

}
