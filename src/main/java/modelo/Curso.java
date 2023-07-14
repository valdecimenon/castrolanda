package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1689345849870894207L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 45)
	private String nome;

	@Column(precision = 5, scale = 2)
	private BigDecimal preco;

	// o carregamento padrão é LAZY (*:*)
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.PERSIST)
	private Set<Estudante> estudantes = new HashSet<>();

	// cosntrutor padrão
	public Curso() {

	}

	// construtor com parâmetros
	public Curso(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Set<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(Set<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	
	public void addEstudante(Estudante estudante) {
		this.estudantes.add(estudante);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("Curso ID: %-5d %-20s R$ %.2f", id, nome, preco);
	}
	

}
