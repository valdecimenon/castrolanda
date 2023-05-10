package excecoes;

/*
 * Exceções verificadas (checked) e não verificadas (unchecked)
 * Verificadas: obrigam o tratamento da exceção, são subclasses de Exception:
 *              IOException, SQLException, ClassNotFoundException, etc
 * Não verificadas: não obrigam. Herdam de RuntimeException
 */
public class ContaRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaRuntimeException(String msg) {
		super(msg);
	}
}
