package modificador_final;

public class LoginFilha extends Login {
	
	// final não deixa sobrescrever o método logar
	/*
	@Override
	public void logar(String usuario, String senha) {
		System.out.println("logou");
	}
	*/
	
	// este posso sobrescrever
	@Override
	public void bemVindo() {
		super.bemVindo();
	}

}
