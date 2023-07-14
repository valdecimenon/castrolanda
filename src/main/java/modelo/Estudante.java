package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

/*
 * Carregamento padrão (fetch):
 * - EAGER (ansioso): One to One ou Many to One
 *   Podemos mudar através da anotação: @Basic(fetch = FetchType.LAZY)
 *   
 * - LAZY (preguiço): One To Many ou Many to Many
 */

@Entity
public class Estudante implements Serializable {

	private static final long serialVersionUID = -5672552369471183952L;

	@Id
	@GeneratedValue
	private Integer id;

	// esse carregamento será feito apenas quando o dado for usado
	// desnecessário aqui, apenas para exemplo
	@Basic(fetch = FetchType.LAZY)
	@Column(length = 45)
	private String nome;

	private Integer idade;

	// Muitos estudantes participam de muitos cursos
	/*
	 * Tipos de fetch: - LAZY ou On Demand: carrega objetos do banco somente quando
	 * necessário. - EAGER: carrega objetos imediatamente. Embora o Eager carregue
	 * mais a memória, há certos casos onde ele é necessário.
	 */
	// Estudante é o dono do relacionamento
	// JoinTable define o nome da tabela contendo as relações com os nomes das
	// chaves
	@JoinTable(name = "matriculados", joinColumns = @JoinColumn(name = "estudante_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) // porém LAZY já é o padrão
	private Set<Curso> cursos = new HashSet<>();

	// construtor padrão
	public Estudante() {

	}

	// construtor com argumentos
	public Estudante(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	// --- CALLBACKS ---
	@PrePersist
	public void prePersist() {
		System.out.println("\nSalvando estudante...");
	}
	
	@PostPersist
	public void postPersit() {
		System.out.println("\nEstudante salvo!");
	}
	
	@PostLoad
	public void postLoad() {
		System.out.println("\nEstudante carregado!");
	}
	
	@PreUpdate
	public void preUpdate() {
		System.out.println("\nAtualizando estudante...");
	}
	
	
	@PostUpdate
	public void postUpdate() {
		System.out.println("\nEstudante atualizado");
	}
	
	@PreRemove
	public void preRemove() {
		System.out.println("\nRemovendo estudante...");
	}
	
	@PostRemove
	public void postRemove() {
		System.out.println("\nEstudante removido");
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public void matricular(Curso curso) {
		this.cursos.add(curso);
		curso.addEstudante(this);
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
		Estudante other = (Estudante) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("Estudante ID: %-5d Nome: %-10s Idade: %d", id, nome, idade);
	}
}
