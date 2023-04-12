package modificadores.pacote2;

import modificadores.pacote1.Animal;

public class Gato extends Animal {

	@Override
	public void metodoPublico() {
		// TODO Auto-generated method stub
		super.metodoPublico();
	}
	
	@Override
	protected void metodoProtected() {
		// TODO Auto-generated method stub
		super.metodoProtected();
	}
	
	// método default não pode ser herdado por uma classe dentro de outro pacote
}
