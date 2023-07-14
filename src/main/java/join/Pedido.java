package join;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import util.DataUtil;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 4668154252967075373L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	// um cliente pode ter muitos pedidos
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cliente cliente;
	
	private LocalDate data;
	
	// construtor padrão
	public Pedido() {

	}

	// segundo construtor
	public Pedido(Cliente cliente, LocalDate data) {
		this.cliente = cliente;
		this.data = data;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id);
	}
		
	@Override
	public String toString() {
		return String.format("Pedido ID: %-5d Data: %s", id, DataUtil.formatarData(data));
	}
}
