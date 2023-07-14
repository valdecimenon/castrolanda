package join;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = -987737100414467128L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	private List<Pedido> pedidos;

	// construtor padrão
	public Cliente() {
		
	}

	// segundo construtor
	public Cliente(String nome) {
		this.nome = nome;
	}

	// alt shift S R
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
		
	@Override
	public String toString() {
		int total = pedidos == null ? 0 : pedidos.size();
		return String.format("Cliente ID: %-5d Nome: %-20s Total de pedidos: %d", id, nome, total);
	}
}
