package modificador_final;

public class Login {

	// final não permite sobrescreve este método
	final public void logar(String usuario, String senha) {
		// codigo aqui...
		System.out.println("logado");
	}
	
	public void bemVindo() {
		System.out.println("Bem Vindo");
	}
}
