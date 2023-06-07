package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// lendo um arquivo texto de um servidor web
public class LerURL {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://softgraf.com/site/index.html");
		System.out.println("Protocolo: " + url.getProtocol());
		System.out.println("Host: " + url.getHost());
		System.out.println("Arquivo: " + url.getFile());
		
		InputStream fluxoBytes = url.openStream();
		InputStreamReader fluxoStrings = new InputStreamReader(fluxoBytes);
		BufferedReader bufferLeitura = new BufferedReader(fluxoStrings);
		
		System.out.printf("\n\n==== Conteúdo do arquivo: %s =====\n\n", url.getFile());
		
		String linha;
		
		while ((linha = bufferLeitura.readLine()) != null) {
			System.out.println(linha);
		}
		
		bufferLeitura.close();
	}
}
