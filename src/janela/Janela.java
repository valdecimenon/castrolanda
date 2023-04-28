package janela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Janela extends JFrame implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 2193264188534068101L;
	final private int TELA_LARGURA = 800;
	final private int TELA_ALTURA = 600;
	private int x = 200;
	private int y = TELA_ALTURA / 2;
	private JButton botao1, botao2, botao3, btnSel;

	public Janela() {
		setLayout(null);
		setSize(TELA_LARGURA, TELA_ALTURA);
		setLocationRelativeTo(null);
		setTitle("Eventos do teclado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botao1 = new JButton("Botão 1");
		botao1.setSize(100, 30);
		botao1.setLocation(x, y);
		botao1.addKeyListener(this);
		botao1.addMouseListener(this);
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSel = botao1;
			}
		});
		add(botao1);

		botao2 = new JButton("Botão 2");
		botao2.setSize(100, 30);
		botao2.setLocation(x + 200, y);
		botao2.addKeyListener(this);
		botao2.addMouseListener(this);
		add(botao2);

		botao3 = new JButton("Botão 3");
		botao3.setSize(100, 30);
		botao3.setLocation(x + 400, y);
		botao3.addKeyListener(this);
		botao3.addMouseListener(this);
		add(botao3);

		addMouseMotionListener(this);
		addMouseWheelListener(this);

		btnSel = botao1;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int x = btnSel.getX();
		int y = btnSel.getY();
	
		
		switch (e.getKeyCode()) {
		

			case KeyEvent.VK_UP:
				y -= 5;
				break;
			
			case KeyEvent.VK_DOWN:
				y += 5;
				break;
				
			case KeyEvent.VK_LEFT:
				x -= 5;
				break;
				
			case KeyEvent.VK_RIGHT:
				x += 5;
				break;
				
			case KeyEvent.VK_P:
				btnSel.setSize((int) (btnSel.getWidth() * 1.1), (int) (btnSel.getHeight() * 1.1));
				break; 
				
			case KeyEvent.VK_MINUS:
				btnSel.setSize((int) (btnSel.getWidth() * 0.9), (int) (btnSel.getHeight() * 0.9));
				break;
		}
		
		if (x < -100)
			x = this.getWidth();
		else if (x > this.getWidth() + 50)
			x = -100;
		
		if (y < -30)
			y = this.getHeight();
		else if (y > this.getHeight() + 15)
			y = -30;
		
		
		btnSel.setLocation(x, y);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	// ==========================================================================

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("X: " + e.getX() + " Y: " + e.getY());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entrou na janela");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		btnSel = (JButton) e.getComponent();

	}

	// ==========================================================================

	@Override
	public void mouseDragged(MouseEvent e) {
		btnSel.setLocation(e.getX(), e.getY());

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		

	}

	// ==========================================================================

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int d = e.getWheelRotation();
		botao1.setLocation(botao1.getX(), botao1.getY() + d);
		botao2.setLocation(botao2.getX(), botao2.getY() + d);
		botao3.setLocation(botao3.getX(), botao3.getY() + d);

	}

}
