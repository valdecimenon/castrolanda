package reflection.entidades;

import reflection.anotacoes.Coluna;
import reflection.anotacoes.Entidade;
import reflection.anotacoes.Id;

@Entidade(nome = "tabela_pessoa")
public class Pessoa {

	private Integer id;
	private String nome;
	private String rua;
	
	// construtor padrão
	public Pessoa() {	}

	public Pessoa(Integer id, String nome, String rua) {
		this.id = id;
		this.nome = nome;
		this.rua = rua;
	}

	@Id(nome = "pk")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Coluna
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Coluna(nome = "Endereco", comprimento = 30)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
}
