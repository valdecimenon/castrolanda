package java12;



// case value -> sintaxe que elimina uso de break
// podemos atribuir uma expressão switch a uma variável
public class ExpressaoSwitchCaseValue {

	private enum DIA {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
	}

	
	public static void main(String[] args) {
		
		DIA dia = DIA.SEGUNDA;
		
		String resultado = switch(dia) {
		
				case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> "Meio da semana";
				
				case SABADO, DOMINGO -> "Fim de Semana";
				
				default -> "Dia inválido";
		};
		
		System.out.println(resultado);
	}

}
