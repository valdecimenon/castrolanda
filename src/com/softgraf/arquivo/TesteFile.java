package com.softgraf.arquivo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteFile {

	public static void main(String[] args) {
		
		File arquivo = new File("c:/");
		System.out.println("Espaço total do disco:" + arquivo.getTotalSpace() / 1024 / 1024 / 1024);
		System.out.println("Espaço total do disco:" + arquivo.getFreeSpace() / 1024 / 1024 / 1024);
		
		// propriedades do arquivo
		arquivo = new File("e:/arquivo.txt");
		System.out.println(arquivo.exists());
		System.out.println("Posso abrir? " + arquivo.canExecute());
		System.out.println("Posso ler? " + arquivo.canRead());
		System.out.println("Posso gravar? " + arquivo.canWrite());
		System.out.println("Caminho absoluto: " + arquivo.getAbsolutePath());
		System.out.println("Nome do arquivo: " + arquivo.getName());
		System.out.println("Diretório pai: " + arquivo.getParent());
		System.out.println("Caminho: " + arquivo.getPath());
		System.out.println("É um arquivo? " + arquivo.isFile());
		System.out.println("É um diretório? " + arquivo.isDirectory());
		System.out.println("É oculto? " + arquivo.isHidden());
		System.out.println("Tamanho: " + arquivo.length() + " bytes");
		System.out.println("Última modificação: " + arquivo.lastModified());
		
		// formata data
		Date data = new Date(arquivo.lastModified());
		System.out.println(data);
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String strData = formatador.format(data);
		System.out.println("Data da última modificação: " + strData);
		
		// renomeia o arquivo
		File arquivo2 = new File("e:/arquivo2.txt");
		System.out.println("\nRenomeando o arquivo para: " + arquivo2.getName());
		if (arquivo.renameTo(arquivo2))
			System.out.println("Arquivo renomeado!");
		else
			System.out.println("Arquivo não renomeado");
		
		// cria arquivo se for inexistente
		File arquivo3 = new File("e:/novoarquivo.txt");
		System.out.println("\nCriando arquivo " + arquivo3.getPath());
		
		try {
			arquivo3.createNewFile();
			System.out.println("\nApagando o arquivo: " + arquivo3.getPath());
			if (arquivo3.delete()) 
				System.out.println("Apagou!!!");
			else
				System.out.println("Não apagou :(");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// cria um diretório
		File diretorio = new File("e:/novapasta");
		System.out.println("\nCriando o novo diretório: " + diretorio);
		if (diretorio.mkdir())
			System.out.println("\nDiretório criado");
		else
			System.out.println("\nErro ao criar diretório");
		
		File windir = new File("C:\\Windows");
		if (windir.list() != null) {
			System.out.println("\nListando conteúdo do diretório: " + windir);
			for (String arq : windir.list()) {
				System.out.println("\t" + arq);
			}
		}
		
	}

}
