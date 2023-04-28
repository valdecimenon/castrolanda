package painter;

import javax.swing.JFrame;

public class JanelaPainter extends JFrame {
	
	public static void main(String[] args) {
		new JanelaPainter();
	}
	

	public JanelaPainter() {
		super("Painter Psicodélico usando modo gráfico");
		setSize(800, 600);
		// centraliza
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// substitui o painel atual pelo personalizado
		setContentPane(new PainelPainter());
		setVisible(true);
	}

}
