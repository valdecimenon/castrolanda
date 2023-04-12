package modificadores.pacote1;

// exemplo de modificadores de acesso
public class Animal {

	// variáveis
	public int a = 1;
	protected int b = 2;
	int c = 3;
	private int d = 4;
	
	// métodos
	// public é visivel para todas as classes de todos os pacotes
	public void metodoPublico() {
		System.out.println("método público");
	}
	
	// protected é visível em outros pacotes, porém apenas por herança
	protected void metodoProtected() {
		System.out.println("método protegido");
	}

	// visível apenas no próprio pacote
	void metodoDefault() {
		System.out.println("método default");
	}
	
	// private é visível apenas para a própria classe
	private void metodoPrivado() {
		System.out.println("método privado");
	}
}
