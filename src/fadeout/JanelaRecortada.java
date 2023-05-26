package fadeout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * Em programação funcional, uma classe ou função anônima é chamada de lambda
 * Em java, representamos lambda por: ->
 * Em javascript, representamos lambda por: =>
 * Em lisp, representamos lambda por: lambda
 */

public class JanelaRecortada extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JFrame JANELA = this;

	public JanelaRecortada() {
		super("Titulo da Janela"); // isso não aparecerá na janela final
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// remove a decoração da janela
		setUndecorated(true);
		getContentPane().setBackground(Color.ORANGE);

		// define uma forma geométrica para ser usada na janela
		Shape elipse = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		Shape retangulo = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 90, 90);

		// define o novo formato da janela atual
		setShape(elipse);

		add(new JLabel("O formato da janela foi alterado", SwingConstants.CENTER), BorderLayout.CENTER);
		add(new JLabel("Clique sobre a janela para fechar. Talvez este texto não apareça..."), BorderLayout.SOUTH);

		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				new Thread( () -> { // implementação do método run() de Runnable

					try {

						for (int i = 20; i > 0; i--) {
							System.out.println("Fechando janela: " + i);
							JANELA.setOpacity(i / 20f);
							Thread.sleep(100);
						}
						
						JANELA.dispose();
						System.out.println("Janela fechada.");
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				}).start();

			} // mouseClicked
		}); // mouseAdapter

		setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaRecortada();
	}
}
