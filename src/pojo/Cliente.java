package pojo;

import java.util.Objects;

/*
 * classe tipo POJO (Plain Old Java Object = bom e velho java)
 *   é uma classe contendo apenas código java puro
 * classe tipo Java Bean
 *   é um POJO contendo pelo menos o construtor padrão e todos os métodos getters e setters
 */
public class Cliente {

	protected String nome;
	private String cnpj;
	
	// construtor padrão
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	

	
	public Cliente(String nome) {
		this.nome = nome;
	}



	// getters e setters: ctrl 3 + ggas
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	// métodos hashCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(nome, other.nome);
	}
	
	
	@Override
	public String toString() {
		return getNome();
	}

	
	
	
}
