package java12;

public class ExpressoSwitchNormal {

	private enum DIA {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
	}

	public static void main(String[] args) {

		DIA dia = DIA.SEGUNDA;
		String resultado;

		switch (dia) {
			case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA:
				resultado = "Meio da semana";
				break;
	
			case SABADO, DOMINGO:
				resultado = "Fim de semana";
				break;
	
			default:
				resultado = "Dia inválido";
		}
		
		System.out.println(resultado);
	}
}
