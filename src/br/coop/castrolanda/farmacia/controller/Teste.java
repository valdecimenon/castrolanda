package br.coop.castrolanda.farmacia.controller;

import static java.lang.System.out;

import br.coop.castrolanda.farmacia.model.Endereco;
import br.coop.castrolanda.farmacia.model.Estoque;

public class Teste {

	public static void main(String[] args) {
		Endereco rua1 = new Endereco()
							.rua("Vicente Machado, 123")
							.cidade("Ponta Grossa")
							.cep("84010-000");
		
		Endereco rua2 = new Endereco()
				.rua("Rua XV, 456")
				.cidade("Curitiba")
				.cep("84010-000");
		
		out.println(rua1);
		out.println(rua2);
		
		Estoque estoque1 = Estoque.getInstancia();
		Estoque estoque2 = Estoque.getInstancia();
		System.out.println(estoque1);
		System.out.println(estoque2);
	}

}
