package agendamento;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAgendamento {

	private static boolean tic = true;
	private static int contador = 0;
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		Timer timerBkup = new Timer();
		
		
		TimerTask tarefa = new TimerTask() {

			@Override
			public void run() {
				System.out.println(tic ? "Tic..." : "Tac...");
				tic = !tic;
				contador++;
				if (contador == 10)
					timer.cancel();
			}
		};
		
		System.out.println("Após 5 segundo o agendamento iniciará...");
		// inicia após 5 segundo e executa a cada 1 segundo
		timer.schedule(tarefa, 5000, 1000);	
		
		// a tarefa (Task) é executa pelo timer
		TimerTask tarefaBkup = new TimerTask() {

			@Override
			public void run() {
				System.out.println("\nFazendo backup do sistema...OK");
				timerBkup.cancel();
			}
		};
		
		// após 30 segundos inicia o bkup
		Date horario = new Date(System.currentTimeMillis() + 30000);
		System.out.println("O bkup iniciára às: " + horario );
		timerBkup.schedule(tarefaBkup, horario);
		
		System.out.println("Fim do main");
	}

}
