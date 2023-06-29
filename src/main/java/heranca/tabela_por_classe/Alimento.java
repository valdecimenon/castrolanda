package heranca.tabela_por_classe;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@PrimaryKeyJoinColumn(name = "produto_id")
public class Alimento extends Produto {

	private BigDecimal peso;
	private Date vencimento;

	// 1234567890.12
	@Column(precision = 10, scale = 2)
	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	@Temporal(TemporalType.DATE)
	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

}
