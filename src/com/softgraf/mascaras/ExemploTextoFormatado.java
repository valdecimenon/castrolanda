/*
Caractere  Descrição

#	Qualquer número, usa Character.isDigit
'	Caractere de escape: \n \r \t
U	Qualquer caractere (Character.isLetter). Converte em letras maiúsculas (Uppercase).
L	Qualquer caractere (Character.isLetter). .Converte em letras minúsculas (Lowercase).
A	Qualquer caractere or number (Character.isLetter ou Character.isDigit)
?	Qualquer caractere (Character.isLetter).
*	Qualquer coisa.
H	Qualquer caractere hexadecimal (0-9, a-f ou A-F).
*/

package com.softgraf.mascaras;

import java.awt.Container;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ExemploTextoFormatado extends JFrame {

	private static final long serialVersionUID = 8455451552139779172L;

	public static void main(String[] args) {
		new ExemploTextoFormatado();
	}
	
	private JLabel lblNome, lblEndereco, lblCep, lblFone;
	private MaskFormatter maskCep, maskFone;
	private JTextField txtNome, txtEndereco;
	private JFormattedTextField tfCep, tfFone;
	private JButton btnSalvar;
	private Container p;

	public ExemploTextoFormatado() {
		super("Exemplo usando JFormattedTextField");
		setLayout(null);
		p = getContentPane();

		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(40, 53, 65, 25);
		p.add(lblNome);

		lblEndereco = new JLabel("Endereço: ");
		lblEndereco.setBounds(40, 83, 65, 25);
		p.add(lblEndereco);

		lblCep = new JLabel("CEP: ");
		lblCep.setBounds(40, 113, 65, 25);
		p.add(lblCep);

		lblFone = new JLabel("Telefone: ");
		lblFone.setBounds(40, 143, 65, 25);
		p.add(lblFone);
		
		try {
			maskCep = new MaskFormatter("#####-###");
			maskCep.setPlaceholderCharacter('_');

			maskFone = new MaskFormatter("(##) ####-####");
			maskFone.setPlaceholderCharacter('_');

		} catch (ParseException e) {
			e.printStackTrace();
		}

		txtNome = new JTextField();
		txtNome.setBounds(110, 50, 250, 25);
		p.add(txtNome);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(110, 80, 250, 25);
		p.add(txtEndereco);

		tfCep = new JFormattedTextField(maskCep);
		tfCep.setBounds(110, 110, 80, 25);
		p.add(tfCep);

		tfFone = new JFormattedTextField(maskFone);
		tfFone.setBounds(110, 140, 125, 25);
		p.add(tfFone);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(160, 200, 70, 25);
		p.add(btnSalvar);

		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
