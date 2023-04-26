package com.softgraf.agenda.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AgendaView extends JFrame {

	private static final long serialVersionUID = -3169463646271405393L;
	private JTabbedPane painelAbas;
	
	// construtor
	public AgendaView(JPanel pnlInclusao){
		super("Agenda 1.0");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		painelAbas = new JTabbedPane();
		painelAbas.addTab("Inclusão", null, pnlInclusao);
		painelAbas.addTab("Consulta", null);
		// troca o conteúdo padrão do JFrame pelo painelAbas, contendo 2 abas
		setContentPane(painelAbas);
		
		
		
		
		setLocationRelativeTo(null);
		
	
	}
	
	

	
}
