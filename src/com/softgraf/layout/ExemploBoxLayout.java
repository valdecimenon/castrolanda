package com.softgraf.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploBoxLayout extends JFrame {

	// redimensione a janela manualmente para ver o layout em ação!
	public static void main(String[] args) {
		new ExemploBoxLayout();
	}

	private static final long serialVersionUID = -2278405546316818567L;
	private JPanel painel1, painel2; 
	private BoxLayout boxLayout1, boxLayout2;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	
	public ExemploBoxLayout(){
		super("Gerenciador BoxLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		painel1 = new JPanel();
		painel2 = new JPanel();
		
		boxLayout1 = new BoxLayout(painel1, BoxLayout.X_AXIS);
		boxLayout2 = new BoxLayout(painel2, BoxLayout.Y_AXIS);
		
		painel1.setLayout(boxLayout1);
		painel2.setLayout(boxLayout2);
		
		painel1.setBackground(Color.GRAY);
		painel2.setBackground(Color.LIGHT_GRAY);
		
		btn1 = new JButton("Botao 1");
		btn2 = new JButton("Botao 2");
		btn3 = new JButton("Botao 3");
		btn4 = new JButton("Botao 4");
		btn5 = new JButton("Botao 5");
		btn6 = new JButton("Botao 6");
		
		painel1.add(Box.createGlue());
		painel1.add(btn1);
		painel1.add(Box.createGlue());
		painel1.add(btn2);
		painel1.add(Box.createGlue());
		painel1.add(btn3);
		painel1.add(Box.createGlue());

		painel2.add(btn4);
		painel2.add(btn5);
		painel2.add(btn6);
		
		// adiciona os painéis sobre o painel de conteúdo do JFrame,
		// usando o layout padrão BorderPane
		add(painel1, BorderLayout.CENTER);
		add(painel2, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
