package com.softgraf.primavera.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.softgraf.primavera.data.model.GrupoCnpj;
import com.softgraf.primavera.data.model.GrupoCpf;
import com.softgraf.primavera.data.model.TipoPessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// LOMBOK
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "nome"})
@ToString

// Anotações JPA
@Table(name = "tabela_clientes")
@Entity
@NamedQuery(name = "Cliente.buscarPF", query="SELECT c FROM Cliente c WHERE c.tipoPessoa = 'Física'")
@NamedQuery(name = "Cliente.buscarPJ", query="SELECT c FROM Cliente c WHERE c.tipoPessoa = 'Jurídica'")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 4106459058064439806L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Tipo de pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8)
	private TipoPessoa tipoPessoa;
	
	// Bean Validation
	@NotBlank(message = "Nome é obrigatório")
	@Size(min=3, max=60)
	// JPA
	@Column(length = 60, nullable = false)
	private String nome;

	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = GrupoCpf.class)
	@CNPJ(groups = GrupoCnpj.class)
	@Column(name = "cpf_cnpj", nullable = false)
	private String cpfOuCnpj;
	
	@Size(max=60)
	@Email(message="E-mail inválido")
	@Column(length = 14)
	private String email;
	
	@Column(length = 14)
	private String fone;
	
	@Embedded
	private Endereco endereco;
	
}
