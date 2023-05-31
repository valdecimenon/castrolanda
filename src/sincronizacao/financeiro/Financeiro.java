package sincronizacao.financeiro;

public class Financeiro implements Runnable {

	private Conta conta;
	private double valorSaque;
	
	// ctrl 3 + gcuf
	public Financeiro(Conta conta, double valorSaque) {
		this.conta = conta;
		this.valorSaque = valorSaque;
	}

	private synchronized void efetuarSaque(double valorSaque) {
		String nome = Thread.currentThread().getName();
		
		if (conta.getSaldo() >= valorSaque) {
			
			System.out.println("Saldo atual = R$ " + conta.getSaldo() + " - " + nome + " irá sacar " + valorSaque);
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			conta.sacar(valorSaque);
			System.out.println(nome + " sacou R$ " + valorSaque + " - Saldo Atual = R$ " + conta.getSaldo() + "\n");
			
		} else {
			System.out.println(nome  + " não consguiu sacar R$ " + valorSaque + " - Saldo Atual = R$ " + conta.getSaldo());
		}
	}



	@Override
	public void run() {
		efetuarSaque(valorSaque);
		if (conta.getSaldo() <= 0)
			System.out.println("O dinheiro acabou");
	}

}
