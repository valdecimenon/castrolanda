package com.softgraf.agenda.controller;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.softgraf.agenda.model.DAO;
import com.softgraf.agenda.view.AgendaView;
import com.softgraf.agenda.view.PainelConsulta;
import com.softgraf.agenda.view.PainelInclusao;
import com.softgraf.agenda.view.PainelTabela;

public class TesteAgendaView {

	public static void main(String[] args) {
		
		DAO.abrir();
		System.out.println("Abriu arquivo");
		
		Dimension dimensao = new Dimension(300, 200);
		JPanel pnlInclusao = new PainelInclusao(dimensao);
		JPanel pnlConsulta = new PainelConsulta(dimensao);
		JPanel pnlTabela = new PainelTabela(dimensao);
		AgendaView janela = new AgendaView(pnlInclusao, pnlConsulta, pnlTabela);
		janela.setVisible(true);
	

	}

}
