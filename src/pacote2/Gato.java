package pacote2;

// Gato É UM Animal e implementa as interfaces Paciente e Medicamento
final public class Gato extends Animal implements Paciente, Medicamento {

	// construtor
	public Gato(String tipoAnimal, String raca) {
		// chama construtor da classe mãe
		super(tipoAnimal, raca);
	}
	
	// implementação das interfaces
	@Override
	public void infoMedicamento() {
		System.out.println("Medicamento: shampoo de clorexidine");
	}

	@Override
	public void infoDosagem() {
		System.out.println("Dosagem: uma vez ao mês, durante 2 meses");
	}

	@Override
	public void mostraNome() {
		System.out.printf("Nome: Tom - o gatito");
	}

	@Override
	public void mostraHistoricoMedico() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostraInformacoesCadastrais() {
		System.out.println("\nTutor: Antonio Americando do Brasil");	
	}
	
	// métodos SOBRECARREGADOS da classe Gato (polimorfismo de método)
	public void miar() {
		System.out.printf("Tom miando: %s\n", "MIAU MIAU");
	}
	
	public void miar(String som) {
		System.out.printf("Tom miando: %s\n", som);
	}
}
