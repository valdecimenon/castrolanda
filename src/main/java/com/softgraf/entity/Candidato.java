package com.softgraf.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.softgraf.model.Sexo;

@Entity
public class Candidato implements Serializable {

	private static final long serialVersionUID = 5270888714529863969L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 30)
	private String sobrenome;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;
	
	@Column(length = 45)
	private String cidade;
	
	private Boolean java;
	private Boolean javascript;
	private Boolean python;
	
	// construtor padrão
	public Candidato() {
		
	}

	public Candidato(String nome, String sobrenome, Sexo sexo, String cidade, Boolean java, 
					 Boolean javascript, Boolean python) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.cidade = cidade;
		this.java = java;
		this.javascript = javascript;
		this.python = python;
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getJava() {
		return java;
	}

	public void setJava(Boolean java) {
		this.java = java;
	}

	public Boolean getJavascript() {
		return javascript;
	}

	public void setJavascript(Boolean javascript) {
		this.javascript = javascript;
	}

	public Boolean getPython() {
		return python;
	}

	public void setPython(Boolean python) {
		this.python = python;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobrenome, other.sobrenome);
	}
	
}
