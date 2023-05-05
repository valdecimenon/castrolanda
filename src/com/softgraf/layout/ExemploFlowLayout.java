package com.softgraf.layout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploFlowLayout extends JFrame {
	
	// redimensione a janela manualmente para ver o layout em ação!
	public static void main(String[] args) {
		new ExemploFlowLayout(800, 400); 
	}

	private static final long serialVersionUID = -5109387287410930776L;
	private JButton btn1, btn2, btn3;
	private JLabel lbl1;
	
	public ExemploFlowLayout(int larg, int alt) {
		super("Gerenciador FlowLayout");
		
		// layout de fluxo
		FlowLayout layout = new FlowLayout();
		// testar com LEFT e RIGHT 
		layout.setAlignment(FlowLayout.CENTER);
		layout.setHgap(50);
		layout.setVgap(50);
		
		setLayout(layout);
		setSize(larg, alt);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		lbl1 = new JLabel("Layout de fluxo");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(lbl1);
		
		setVisible(true);
	}
}
