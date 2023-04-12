package br.coop.castrolanda.farmacia.controller;

import br.coop.castrolanda.farmacia.model.Item;
import br.coop.castrolanda.farmacia.model.Produto;

public class TesteItem {

	public static void main(String args[]) {
		Produto p1 = new Produto("P1", "Remédio", 19.90f);
		Item itemA = new Item(p1, 10);
		System.out.println(itemA.getNumero());  // 1
		
		Item itemB = new Item(p1, 10);
		itemB.setNumero(-1);
		System.out.println(itemB.getNumero());  // 
		
		Item itemC = new Item(p1, 10);
		System.out.println(itemC.getNumero());  // 
		
		
	}

}
