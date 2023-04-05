package pacote2;

// uma interface é como uma classe, sem métodos, ou seja, existem somente assinaturas
// que devem ser implementadas por quem usar esta interace.
// É tipo um contrato onde os métodos são as cláusulas deste contrato.
// A classe que implementar (implements) a interface é obrigada a cumprir o contrato!
public interface Paciente {

	// todos os métodos são implicitamente públicos
	void mostraNome();
	
	// public aqui é redundante
	public void mostraHistoricoMedico();
	
	void mostraInformacoesCadastrais();
}
