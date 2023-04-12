package enumeracao;

public class TesteDias {

	public static void main(String[] args) {
		
		DiaSemana dia1 = DiaSemana.DOMINGO;
		DiaSemana dia2 = DiaSemana.SEGUNDA;		
		DiaSemana dia3 = DiaSemana.TERCA;
		
		System.out.println(dia1);
		for (DiaSemana dia : DiaSemana.values()) {
			System.out.println(dia);
		}

	}

}
