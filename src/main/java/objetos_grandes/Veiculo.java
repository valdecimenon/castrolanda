package objetos_grandes;
/*
 * - CLOB - Character Large Object - para arquivos em formato texto
 *   é um tipo do banco de dados usado para armazenar objetos grandes em formato texto.
 *   para mapear um CLOB usamos a anotação @Lob que pode ser usada para os tipos String,
 *   char[] ou Character[]
 *   
 * - BLOB - Binary Large Object - para arquivos binários, imagens, músicas, etc.
 *   é um tipo do banco de dados para armazenar objetos grandes em formato binário.
 *   para mapear um BLOB também usamos a anotação @Lob que pode ser usada para os tipos
 *   byte[] ou Byte[]
 *   
 */

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -6187850159761266822L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 20)
	private String marca;
	
	@Column(length = 60)
	private String modelo;
	
	// permite armazenar mais de 255 caracteres
	// No Mysql será criado uma coluna do tipo TEXT
	@Lob
	private String descricao;
	
	// permite armazenar dados binários
	// No Mysql será criado uma coluna do tipo BLOB
	@Lob
	private byte[] foto;
	
	// Atenção
	// Este campo não será persistido no banco de dados!!
	@Transient
	private String naoSeraSalvo;

	// getters e setters
	// novo atalho: alt + shift + s + r
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNaoSeraSalvo() {
		return naoSeraSalvo;
	}

	public void setNaoSeraSalvo(String naoSeraSalvo) {
		this.naoSeraSalvo = naoSeraSalvo;
	}
	

	

	
}
