package com.softgraf.agenda.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;

public class PainelInclusao extends JPanel {
	
	private static final long serialVersionUID = 532563463073781482L;
	// usa layout de fluxo: posiciona automaticamente os comp. da esquerda para a direita, de cima para baixo
	private FlowLayout layout;
	private PainelContato pnlContato;
	private JButton btnSalvar;
	private JTextField txtAviso;
	private Contato contato;
	
	public PainelInclusao(Dimension dimensao) {
		contato = new Contato();
		
		// preenche o bean contato com dados do DAO
		try {
			
			int quant = DAO.getArquivo().quantidadeRegistros();
			contato.setId(quant + 1);
			
		} catch (IOException e) {
			Msg.erro("erro fatal ao ler o arquivo de dados.");
			e.printStackTrace();
			System.exit(0);
		}
		
		layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);
		//                      r     g     b  = 0..255  
		setBackground(new Color(220, 255, 255));
		setPreferredSize(dimensao);
		
		pnlContato = new PainelContato(contato, true);
		add(pnlContato);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoSalvar());
		add(btnSalvar);
		
		txtAviso = new JTextField(22);
		txtAviso.setBackground(getBackground());
		txtAviso.setForeground(Color.RED);
		txtAviso.setEditable(false);
		txtAviso.setBorder(null);
		txtAviso.setHighlighter(null);
		add(txtAviso);
	}
	
	
	private class AcaoSalvar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (contato.getNome().length() < 6 || contato.getFone().length() < 8) {
				txtAviso.setText("Dados incompletos!");
			} else {
				
				try {
					DAO.getArquivo().gravarContato(contato);
					txtAviso.setText("Contato salvo com sucesso!");
					int id = contato.getId();
					contato = new Contato();
					contato.setId(id + 1);
					pnlContato.setContato(contato);
					
				} catch (IOException e1) {
					Msg.erro("Erro ao salvar contato");
					e1.printStackTrace();
				}
				
			}
			
		}
		
	}
	
}
