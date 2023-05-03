package com.softgraf.agenda.view;

import static javax.swing.JOptionPane.*;

public class Msg {

	public static void aviso(String msg) {
		showMessageDialog(null, msg, "Aviso", WARNING_MESSAGE);
	}
	
	public static void erro(String msg) {
		showMessageDialog(null, msg, "Erro", ERROR_MESSAGE);
	}
}
