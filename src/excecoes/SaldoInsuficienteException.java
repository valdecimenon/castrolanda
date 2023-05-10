package excecoes;

public class SaldoInsuficienteException extends ContaRuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	
}
