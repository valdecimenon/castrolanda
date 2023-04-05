package pacote2;

// Objetivo: compreender herança, classe final, interface, polimorfismo de método
// Regra do Mussum:
// Herança você extends
// Interface você implements
public class Principal {

	public static void main(String[] args) {
		Paciente alberto = new Pessoa("Alberto", "M");
		Paciente tom = new Gato("Gato", "siamês");
		
		// usando polimorfismo com casting
		System.out.println("\n==== Dados da Pessoa =====");
		// erro: a interface Paciente não possui o método getSexo()
		// alberto.getSexo();
		// porém alberto É UM Humano, logo posso acessar através de casting (desce o nível hierárquico de ref. do objeto)
		String sexo = ((Humano) alberto).getSexo();
		System.out.println("Sexo: " + sexo);
		
		alberto.mostraNome();
		alberto.mostraHistoricoMedico();
		alberto.mostraInformacoesCadastrais();
		
		// acessa os métodos da interface Medicamento
		((Medicamento) alberto).infoMedicamento();
		((Medicamento) alberto).infoDosagem();
		
		
		
		System.out.println("\n===== Dados do Gato =====");
		String tipo = ((Animal) tom).getTipoAnimal();
		System.out.println("Tipo de animal: " + tipo);
		
		String raca = ((Animal) tom).getRaca();
		System.out.println("Raça do animal: " + raca);
		
		tom.mostraNome();
		tom.mostraInformacoesCadastrais();
		
		// acessa os métodos da interface Medicamento
		((Medicamento) tom).infoMedicamento();
		((Medicamento) tom).infoDosagem();
	}

}
