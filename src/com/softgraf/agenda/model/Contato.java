package com.softgraf.agenda.model;

// java bean
// representa uma entidade no banco de dados
public class Contato {

	// alterar o tipo para Long
	private Long id;     // PRIMARY KEY
	private String nome; // VARCHAR(60)
	private String fone; // VARCHAR(14)

	// construtor padrão para inicialização
	public Contato() {
		
	}
	
	public Contato(String nome, String fone) {
		this(null, nome, fone);
	}

	public Contato(Long id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
