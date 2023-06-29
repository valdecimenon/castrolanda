package heranca.tabela_unica;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

// ORM -> Object Relational Mapping = mapeamento objeto-relacional (converter objeto em tabela)
// cuidado! ao renomear a tabela,  aquery precisa usar o novo nome!
@Entity(name = "tbl_produtos")

// Estratégia SINGLE TABLE - esse já é o padrão
// cria uma tabela única (tabelão) para todas as classes concretas (classes filhas)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1)
abstract public class Produto {

	private Long id;
	private String descricao;
	private Unidade unidade;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(EnumType.STRING)
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
