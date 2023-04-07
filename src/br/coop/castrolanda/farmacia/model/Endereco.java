package br.coop.castrolanda.farmacia.model;

// Design Pattern Fluent Interface
public class Endereco {

	private String rua;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco() {
		this.estado = "PR";
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	// alterar os métodos
	public Endereco rua(String rua) {
		this.rua = rua;
		return this;
	}

	public Endereco cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public Endereco estado(String estado) {
		this.estado = estado;
		return this;
	}

	public Endereco cep(String cep) {
		this.cep = cep;
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("%-30s %-20s %-5s %s", rua, cidade, estado, cep);
	}

}
