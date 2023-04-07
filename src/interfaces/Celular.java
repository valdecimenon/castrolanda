package interfaces;

public class Celular implements Smartphone {

	@Override
	public void ligar() {
		System.out.println("Ligado");
		
	}

	@Override
	public void desligar() {
		System.out.println("Desligado");
		
	}

	@Override
	public void sintonizar() {
		System.out.println("Celular tocando musica");
		
	}


}
