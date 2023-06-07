package datas;

import java.util.Date;

// usando a antiga classe java.util.Date
// representa data e hora
public class CriandoDatas {

	public static void main(String[] args) {
		final long MILI_SEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000;
		Date hoje = new Date();
		System.out.println("Agora é: " + hoje);
		
		long tempo = hoje.getTime();
		System.out.println(tempo);
		
		// tempo decorrido em milissegundos desde 01/JAN/1970
		long dias = tempo / MILI_SEGUNDOS_POR_DIA;
		long anos = dias / 365;
		long meses = anos * 12;
		long horas = dias * 24;
		
		System.out.println("Tempo decorrido desde 1o de janeiro de 1970");
		System.out.printf("Em dias: %d \nEm meses: %d \nEm anos: %d \nEm horas: %d \n\n",
						  dias, meses, anos, horas);
		
		// hoje + 10 dias
		Date novaData = new Date(hoje.getTime() + (MILI_SEGUNDOS_POR_DIA * 10));
		System.out.println("Daqui 10 dias será: " + novaData);
		
		// Alterando a data
		novaData.setTime(hoje.getTime() - MILI_SEGUNDOS_POR_DIA * 30);
		System.out.println("30 dias atrás foi: " + novaData);
		
		// comparando datas
		if (novaData.after(hoje))
			System.out.println("nova data é posterior");
		else
			System.out.println("nova data é anterior");
		
		// métodos depreciados (você pode usar, mas deve evitar)
		long dataMilissegundos = Date.parse("06/06/2023");
		Date data = new Date("06/06/2023");
		int tempoDdias = data.getDay();
		int tempoHoras = data.getHours();
		// etc
	}

}
