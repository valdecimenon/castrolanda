package pacote2;

// podemos implementar uma ou mais interfaces em uma classe
// porém uma classe NÃO PODE estender mais de classe mãe: só existe uma mãe!
// excessão: outras linguagens, como C/C++ permitem estender mais de uma classe, mas o Java não!

// Pessoa É UM Humano e implementa as interfaces Paciente e Medicamento
final public class Pessoa extends Humano implements Paciente, Medicamento {

	// campo do objeto ou variável da classe
	private String nome;
	

	// construtor com 2 parâmetros
	public Pessoa(String nome, String sexo) {
		super(sexo);
		this.nome = nome;
	}
	
	// métodos sobrescritos vindos das interfaces
	@Override
	public void infoMedicamento() {
		System.out.println("Medicamento: ácido acetilsalicílico");
		
	}

	@Override
	public void infoDosagem() {
		System.out.println("Dosagem: 03 comprimidos ao dia");
		
	}

	@Override
	public void mostraNome() {
		System.out.printf("Nome: %s\n", nome);
	}

	@Override
	public void mostraHistoricoMedico() {
		System.out.println("Histórico: tratando-se há 3 meses...");
		
	}

	@Override
	public void mostraInformacoesCadastrais() {
		System.out.println("Cadastro: Av. Vicente Machado, 123");
	}

}
