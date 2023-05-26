package relogio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaRelogio extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel lblHora;
	private JButton btnIniciar, btnDormir, btnInterromper, btnFechar;
	private SimpleDateFormat formatador;  // formatador de data
	private Thread threadRelogio;

	
	// construtor
	public JanelaRelogio() {
		// converte a hora do sistema (valor tipo long) para o formato string abaixo
		formatador = new SimpleDateFormat("hh:mm:ss");
		Toolkit kit = Toolkit.getDefaultToolkit();
		int largura = kit.getScreenSize().width;
		
		setSize(220, 250);
		setLayout(null);
		setLocation(largura - 200, 0);
		
		// remove a decoração (moldura da janela) para aceitar transparência
		setUndecorated(true);
		// fundo transparente
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f)); // 0.5 = 50% de opacidade
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// instancia componentes swing
		lblHora = new JLabel("00:00:00");
		lblHora.setBounds(50, 20, 150, 30);
		lblHora.setFont(new Font(lblHora.getFont().getName(), Font.PLAIN, 30));
		add(lblHora);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(40, 70, 150, 30);
		add(btnIniciar);
		
		btnDormir = new JButton("Dormir");
		btnDormir.setBounds(40, 110, 150, 30);
		add(btnDormir);
		
		btnInterromper = new JButton("Interromper");
		btnInterromper.setBounds(40, 150, 150, 30);
		add(btnInterromper);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(40, 190, 150, 30);
		add(btnFechar);
		
		threadRelogio = new Thread(this);
		
		
		btnIniciar.addActionListener(e -> threadRelogio.start());
		
		btnDormir.addActionListener(e -> {
			System.out.println("\nDormindo 5 segundos...");
			
			try {
				Thread.sleep(5000);
				System.out.println("Acordou");
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		btnInterromper.addActionListener(e -> threadRelogio.interrupt());
		
		
		btnFechar.addActionListener(e -> {
			System.out.println("Fechando...");
			dispose();
		});
	}
	
	
	@Override
	public void dispose() {
		System.out.println("Adeus");
		threadRelogio = null;
		super.dispose();
	}
	
	
	@Override
	public void run() {
		System.out.println("Running...");
		
		
		while (threadRelogio != null) {
			atualizarHora();
			
			try {
				Thread.sleep(0);
				
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida");
				e.printStackTrace();
				
//				threadRelogio = null;
			}
			
		}
		
	}
	
	private void atualizarHora() {
		String hora = formatador.format(new Date());
		lblHora.setText(hora);
	}


	public static void main(String[] args) {
		JFrame relogio = new JanelaRelogio();
		relogio.setVisible(true);
	}
	

}
