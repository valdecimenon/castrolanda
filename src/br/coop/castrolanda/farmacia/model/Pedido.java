package br.coop.castrolanda.farmacia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// java bean
public class Pedido {

	private int numero;
	private Date data;
	private Cliente cliente;
	// Tipos de associação entre classes
	// Composição  = associação FORTE = Losango cheio
	// Agregação  = associação fraca = Losango vazado
	private List<Item> lista;
	
	// construtor padrão
	public Pedido() {
		this(0, null, null);
	}
	
	public Pedido(int numero, Item item, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		lista = new ArrayList<>();
		lista.add(item);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public boolean addItem(Item item) {
		return lista.add(item);
	}
	
	public boolean removeItem(Item item) {
		return lista.remove(item);
	}
	
	
	public List<Item> listaItens(){
		// retorna uma lista apenas para leitura, não permite alterar
		return Collections.unmodifiableList(lista);
	}
	

	
}
