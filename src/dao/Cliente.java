package dao;

// java bean
public class Cliente {

	private String nome;
	private char tipo;  // 'F', 'J'
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
