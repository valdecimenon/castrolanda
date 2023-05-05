package com.softgraf.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploBorderLayout extends JFrame {

	// redimensione a janela manualmente para ver o layout em ação!
	public static void main(String[] args) {
		new ExemploBorderLayout(600, 400);
	}
	
	private static final long serialVersionUID = 7103302371220606722L;
	private JButton btnNorte, btnSul, btnLeste, btnOeste, btnCentro;

	public ExemploBorderLayout(int larg, int alt) {
		super("Gerenciador padrão BorderLayout");
		setSize(larg, alt);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		btnNorte = new JButton("Norte");
		btnSul = new JButton("Sul");
		btnLeste = new JButton("Leste");
		btnOeste = new JButton("Oeste");
		btnCentro = new JButton("Centro");
		
		btnNorte.setPreferredSize(new Dimension(0, 100));
		btnSul.setPreferredSize(new Dimension(0, 100));

		btnLeste.setPreferredSize(new Dimension(200, 0));
		btnOeste.setPreferredSize(new Dimension(200, 0));

		add(BorderLayout.NORTH, btnNorte);
		add(BorderLayout.SOUTH, btnSul);
		add(BorderLayout.EAST, btnLeste);
		add(BorderLayout.WEST, btnOeste);
		add(BorderLayout.CENTER, btnCentro);

		setVisible(true);
	}
}
