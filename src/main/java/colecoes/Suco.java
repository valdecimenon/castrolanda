package colecoes;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/*
 * A entidade abaixo tem um atributo tipo lista, o qual não faz referência a uma entidade,
 * portanto não podemos criar um relacionamento!
 * Neste caso devemos usar @ElementCollection
 */

@Entity
public class Suco implements Serializable {

	private static final long serialVersionUID = 462583944597765420L;

	private Integer id;
	private String marca;
	private List<String> sabores;

	// getters e setters
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@ElementCollection
	@Column(length = 20)
	public List<String> getSabores() {
		return sabores;
	}

	public void setSabores(List<String> sabores) {
		this.sabores = sabores;
	}

}
