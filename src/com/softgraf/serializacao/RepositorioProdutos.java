package com.softgraf.serializacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProdutos implements Serializable {

	private static final long serialVersionUID = 2991976594990729860L;

	private List<Produto> lista = new ArrayList<>();
	
	public void add(Produto p) {
		lista.add(p);
	}
	
	@Override
	public String toString() {
		String texto = "";
		for (Produto produto : lista) {
			texto += produto.toString() + "\n";
		}
		
		return texto;
	}
}
