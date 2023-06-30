package incorporavel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// Componente incorporável em uma entidade jpa
@Embeddable 
public class Endereco {

	private String rua;
	private String cidade;
	private String uf;

	@Column(length = 45)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(length = 20, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@NotBlank(message = "faltou estado")
	@Size(min=2, max=2)
	@Column(length = 2, nullable = false)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
