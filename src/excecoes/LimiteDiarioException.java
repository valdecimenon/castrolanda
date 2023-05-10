package excecoes;

public class LimiteDiarioException extends ContaRuntimeException {

	private static final long serialVersionUID = 1L;

	public LimiteDiarioException(String msg) {
		super(msg);
	}

}
