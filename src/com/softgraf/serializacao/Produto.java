package com.softgraf.serializacao;

import java.io.Serializable;

public class Produto implements Serializable {

	private static final long serialVersionUID = 2462822658242920194L;
	private int id;
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d  Descrição: %s", id, descricao);
	}

}
