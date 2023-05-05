package com.softgraf.serializacao;

import java.io.Serializable;

// java bean
// Serializable é uma interface de marcação! (não possui métodos)
public class Cliente implements Serializable {

	// campo de serialização: gerado automaticamente
	private static final long serialVersionUID = 370692993491530520L;
	// campos da classe
	private int id;
	private String nome;
	private String fone;
	private double saldo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
               
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d Nome: %s Fone: %s Saldo: %f", id, nome, fone, saldo);
	}

}
