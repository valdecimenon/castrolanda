package padrao;

@FunctionalInterface
public interface Impressao {

	void imprimir(String msg);
	
	default void teste() {
		System.out.println("implementacao de método");
	}
}
