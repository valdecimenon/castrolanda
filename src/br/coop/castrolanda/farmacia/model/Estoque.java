package br.coop.castrolanda.farmacia.model;

public class Estoque {
	
	private static Estoque estoque = null;
	
	private Estoque() {
		estoque = this;
	}
	
	public static Estoque getInstancia() {
		return (estoque == null) ? new Estoque() : estoque;
	}

}
