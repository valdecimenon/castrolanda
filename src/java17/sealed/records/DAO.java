package java17.sealed.records;

public sealed interface DAO permits Cliente {
	
	void salvar(String nome);

}
