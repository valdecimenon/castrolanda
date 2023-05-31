package sincronizacao.financeiro;

public class Conta {

	private double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valorSaque) {
		this.saldo -= valorSaque;
	}
}
