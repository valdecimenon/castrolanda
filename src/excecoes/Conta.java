package excecoes;

// Lançamento de exceções personalizadas
public class Conta {

	private String titular;
	private double saldo;

	public Conta(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double saque) throws ContaRuntimeException  {
		if (saque == 0) {
			throw new SaqueZeroException("Tentativa de sacar R$ 0,00");
			
		} else if (saque < 0) {
			throw new SaqueNegativoException("Tentativa de saque negativo");
			
		} else if (saldo < saque) {
			throw new SaldoInsuficienteException("Conta com saldo insuficiente");
			
		} else if (saque > 1000) {
			throw new LimiteDiarioException("Excedido limite de saque diário");
			
		} else
			saldo -= saque;
	}
	
	@Override
	public String toString() {
		return String.format("Titular: %-20s Saldo: R$ %.2f", titular, saldo);
	}
	
}
