package com.softgraf.agenda.model;

// java bean
public class Contato {

	private int id; // 4 bytes
	private String nome; // 40 byts
	private String fone; // 20 bytes => 64 bytes

	// construtor padrão para inicialização
	public Contato() {
		this(1, "", "");
	}

	// construtor de 3 parâmetros
	public Contato(int id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}

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
	
	@Override
	public String toString() {
		return String.format("ID: %-5d Nome: %-20s Fone: %s", id, nome, fone);
	}
}
