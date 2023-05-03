package com.softgraf.agenda.model;

import java.io.IOException;
import com.softgraf.agenda.view.Msg;

// Objeto de Acesso a Dados = DAO
public class DAO {

	private static ArquivoBinario arquivo = null;
	
	public static void abrir() {
		arquivo = new ArquivoBinario();
		
		try {
			arquivo.abrirArquivo("agenda.dat");
			
		} catch (IOException e) {
			Msg.erro("Não foi possível criar/abrir arquivo agenda.dat" );
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void fechar() {
		try {
			arquivo.fecharArquivo();
		} catch (IOException e) {
			Msg.erro("Não foi possível fechar arquivo agenda.dat" );
			e.printStackTrace();
		}
	}
	
	public static ArquivoBinario getArquivo() {
		return arquivo;
	}
}
