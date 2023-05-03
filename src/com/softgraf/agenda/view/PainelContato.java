package com.softgraf.agenda.view;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.softgraf.agenda.model.Contato;

public class PainelContato extends JPanel {

	private static final long serialVersionUID = -1197864615703860416L;
	private Contato contato;
	private JLabel lblId, lblNome, lblFone;
	private JTextField txtId, txtNome, txtFone;

	public PainelContato(Contato contato, boolean editar) {
		setLayout(null);  // "null layout"
		setPreferredSize(new Dimension(250, 120));
		
		lblId = new JLabel("ID:");
		lblId.setBounds(20, 20, 60, 20);
		add(lblId);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 50, 60, 20);
		add(lblNome);
		
		lblFone = new JLabel("Fone:");
		lblFone.setBounds(20, 80, 60, 20);
		add(lblFone);
		
		txtId = new JTextField();
		txtId.setBounds(80, 20, 30, 20);
		txtId.setEditable(false);
		add(txtId);
		
		txtNome = new JTextField();
		txtNome.setBounds(80, 50, 150, 20);
		txtNome.setEditable(editar);
		txtNome.addFocusListener(new AcaoNome());
		add(txtNome);

		txtFone = new JTextField();
		txtFone.setBounds(80, 80, 100, 20);
		txtFone.setEditable(editar);
		txtFone.addFocusListener(new AcaoFone());
		add(txtFone);
		
		setContato(contato);
	}
	
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
		txtId.setText(String.valueOf(contato.getId()));
		txtNome.setText(contato.getNome());
		txtFone.setText(contato.getFone());
	}
	
	/*
	 * padrão Adapter
	 * classes adaptadores (de interfaces)
	 * FocusListener => FocusAdapter
	 * MouseMotionListener => MouseMotionAdapter
	 * KeyListener => KeyAdapter
	 */
	private class AcaoNome extends FocusAdapter {

		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtNome.getText();
			int max = texto.length() < 20 ? texto.length() : 20;
			
			// limita o nome com no máximo 20 caracteres
			txtNome.setText(texto.substring(0, max).trim());
			contato.setNome(txtNome.getText());
		}
	}
	
	private class AcaoFone extends FocusAdapter {
		
		@Override
		public void focusLost(FocusEvent e) {
			String texto = txtFone.getText();
			int max = texto.length() < 10 ? texto.length() : 10;
			
			// limita o fone com no máximo 10 caracteres
			txtFone.setText(texto.substring(0, max).trim());
			contato.setFone(txtFone.getText());
		}
		
	}

}
