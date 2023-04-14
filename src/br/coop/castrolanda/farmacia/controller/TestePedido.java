package br.coop.castrolanda.farmacia.controller;

import java.util.List;

import br.coop.castrolanda.farmacia.model.Cliente;
import br.coop.castrolanda.farmacia.model.Item;
import br.coop.castrolanda.farmacia.model.Pedido;
import br.coop.castrolanda.farmacia.model.Produto;

public class TestePedido {

	public static void main(String[] args) {
		Produto prod1 = new Produto("M1", "melhoral infantil", 1.99f);
		Produto prod2 = new Produto("M2", "remedio pra aids", 299.99f);
		
		Item item1 = new Item(prod1, 10);
		Item item2 = new Item(prod2, 1);
		
		Cliente joao = new Cliente();
		Pedido ped1 = new Pedido(101, item1, joao);
		ped1.addItem(item2);
		
		List<Item> lista = ped1.listaItens();
		
		// não posso modificar a lista retornada!!!
		//  java.lang.UnsupportedOperationException
		lista.remove(0);
		

	}

}
