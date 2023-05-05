package com.softgraf.layout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExemploGridLayout extends JFrame {

	// redimensione a janela manualmente para ver o layout em ação!
	public static void main(String[] args) {
		new ExemploGridLayout();
	}
	
	private static final long serialVersionUID = 5030304182169413153L;
	private JLabel lblNome, lblFone;
	private JTextField txtNome, txtFone;
	private JButton btnOK;

	public ExemploGridLayout() {
		super("Gerenciador GridLayout");
		
		// 3 linhas, 2 colunas
		setLayout(new GridLayout(3, 2));
		
		// linha 1, coluna 1
		lblNome = new JLabel("Nome:");
		add(lblNome);
		
		// linha 1, coluna 2
		txtNome = new JTextField(15);
		add(txtNome);
		
		// linha 2, coluna 1
		lblFone = new JLabel("Fone:");
		add(lblFone);
		
		// linha 2, coluna 2
		txtFone = new JTextField(15);
		add(txtFone);
		
		// linha 3, coluna '
		btnOK = new JButton("OK");
		add(btnOK);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
