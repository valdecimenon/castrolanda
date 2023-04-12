package br.coop.castrolanda.farmacia.model;

public class Produto {

	private String codigo;
	private String descricao;
	private float precoUnitario;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String codigo, String descricao, float precoUnitario) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

}
