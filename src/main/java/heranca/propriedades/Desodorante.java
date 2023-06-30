package heranca.propriedades;

import jakarta.persistence.Entity;

@Entity
public class Desodorante extends Produto {

	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
