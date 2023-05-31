package sincronizacao.financeiro;

public class TesteFinanceiro {

	public static void main(String[] args) {
		
		/*
		 * instancia uma nova conta com saldo inicial de R$ 5000.0 e saques de R$ 1000.0
		 * depois executa os saques usando a threads
		 */
		Financeiro r = new Financeiro(new Conta(5000.0), 1000.0);
		
		Thread joao = new Thread(r, "João");
		Thread maria = new Thread(r, "Maria");
		Thread andre = new Thread(r, "Andre");
		Thread rafael = new Thread(r, "Rafael");
		
		// executa as threads -> efetuam saque de 1000.0 cada um
		joao.start();
		maria.start();
		andre.start();
		rafael.start();

	}

}
