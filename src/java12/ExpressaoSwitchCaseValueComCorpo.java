package java12;

public class ExpressaoSwitchCaseValueComCorpo {
	private enum DIA {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
	}

	
	public static void main(String[] args) {
		
		DIA dia = DIA.SEGUNDA;
		boolean invalido = false;
		
		switch(dia) {
		
				case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> System.out.println("Meio da semana");
				
				case SABADO, DOMINGO -> System.out.println("Fim de Semana");
				
				// aqui criamos um corpo
				default -> {
								invalido = true;
								System.out.println("Dia inválido");
						  }
		};
		
		System.out.println(invalido);
	}
}
