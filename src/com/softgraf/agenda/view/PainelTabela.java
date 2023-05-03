package com.softgraf.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;

public class PainelTabela extends JPanel {

	private static final long serialVersionUID = 2004909179341863149L;
	// componente gráfico
	private JTable table;
	// estrutura de dados da tabela
	private DefaultTableModel tableModel;
	// painel de rolagem
	private JScrollPane scroll;
	// array contendo o nome das colunas
	private String[] colunas;
	// lista de contatos de agenda.dat
	private List<Contato> contatos;
	
	public PainelTabela(Dimension dimensao) {
		setBackground(new Color(255, 255, 220));
		
		// nome das colunas, usando inicializador de array
		colunas = new String[] {"ID", "NOME", "FONE"};
		
		// estrutura de dados
		tableModel = new DefaultTableModel();
		
		// adiciona colunas na estrutra de dados da tabela
		tableModel.addColumn(colunas[0]);
		tableModel.addColumn(colunas[1]);
		tableModel.addColumn(colunas[2]);
		
		carregarContatos();
		for (Contato c : contatos) {
			String[] linha = {String.valueOf(c.getId()), c.getNome(), c.getFone()};
			tableModel.addRow(linha);
		}
		
		// instancia a tabela com base no modelo de dados
		table = new JTable(tableModel);
		
		// instancia o painel de rolagem
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(dimensao);
		
		// usa layout padrão do JPanel: BorderLayout
		add(scroll, BorderLayout.CENTER);
	}
	
	
	private void carregarContatos() {
		
		contatos = new ArrayList<>();
		try {
			int quant = DAO.getArquivo().quantidadeRegistros();
			
			if (quant > 0) {
				for (int i=1; i<= quant; i++) {
					Contato contato = DAO.getArquivo().lerContato(i);
					contatos.add(contato);
				}
			}
			
			
		} catch (IOException e) {
			Msg.erro("Erro ao ler o arquivo de dados agenda.dat");
			e.printStackTrace();
		}
		
	}
	

	
}
