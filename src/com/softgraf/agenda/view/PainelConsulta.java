package com.softgraf.agenda.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;

public class PainelConsulta extends JPanel {

	private static final long serialVersionUID = -2320479405685672559L;
	private FlowLayout layout;
	private JSlider slider;
	private Color corFundo;
	private PainelContato pnlContato;

	public PainelConsulta(Dimension dimensao) {
		corFundo = new Color(255, 220, 255);
		setBackground(corFundo);
		// gap: 10,10
		layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);
		// tamanho do painel
		setPreferredSize(dimensao);
		addComponentListener(new AcaoExibir());

		pnlContato = new PainelContato(new Contato(), false);
		add(pnlContato);

		// slider horizontal, valor mínimo=1, valor máximo=1, valor inicial=1
		slider = new JSlider(JSlider.HORIZONTAL, 1, 1, 1);
		slider.setPreferredSize(new Dimension(dimensao.width - 50, 50));
		slider.setBackground(corFundo);
		slider.setLabelTable(slider.createStandardLabels(1));
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mostraRegistros();
			}
		});
		add(slider);
	}

	private class AcaoExibir extends ComponentAdapter {
		@Override
		public void componentShown(ComponentEvent e) {
			mostraRegistros();
		}
	}

	private void mostraRegistros() {
		int quant = 0;

		try {
			quant = DAO.getArquivo().quantidadeRegistros();

		} catch (IOException e) {
			Msg.erro("Erro ao ler o arquivo de dados agenda.dat");
		}

		if (quant > 0) {
			slider.setEnabled(true);
			slider.setMaximum(quant);
			
			try {

				int numero = slider.getValue();
				Contato contato = DAO.getArquivo().lerContato(numero);
				pnlContato.setContato(contato);
				
			} catch (IOException e) {
				Msg.erro("Erro ao ler registro do arquivo de dados agenda.dat");
			}
		} else {
			slider.setEnabled(false);
		}
	}
}
