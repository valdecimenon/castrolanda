package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JPanel;

public class PainelPainter extends JPanel {

	private static final long serialVersionUID = -2670645523046753113L;
	private int contagemPontos = 0;
	private Point[] pontos = new Point[10000];
	private Random random = new Random();
	private int red, green, blue;

	public PainelPainter() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (contagemPontos < pontos.length) {

					pontos[contagemPontos] = e.getPoint();
					contagemPontos++;
					// chama paintComponent() => redesenha a tela
					repaint();
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < contagemPontos; i++) {
			red = random.nextInt(256); // 0 a 255
			green = random.nextInt(256); // 0 a 255
			blue = random.nextInt(256); // 0 a 255
			g.setColor(new Color(red, green, blue));
			g.fillOval(pontos[i].x, pontos[i].y, 40, 40);
		}
	}

}
