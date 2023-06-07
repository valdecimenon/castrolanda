package redes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

/*
 * "ftp://usuario:senha@softgraf.com/teste_ftp/arquivo" 
 * usuario = cursojava@softgraf.com
 * senha = cursojava
 */
public class FtpDownload {

	public static void main(String[] args) throws IOException {

		String ftpUsuario = URLEncoder.encode("cursojava@softgraf.com", "UTF-8");
		String ftpSenha = URLEncoder.encode("cursojava", "UTF-8");
		String ftp = String.format("ftp://%s:%s@softgraf.com/teste_ftp/imagem.jpg", ftpUsuario, ftpSenha);

		URL url = new URL(ftp);
		InputStream entrada = url.openStream();
		FileOutputStream saida = new FileOutputStream("e:/imagem.jpg");
		int v;

		System.out.println("\nFazendo download...");
		while ((v=entrada.read()) != -1) {
			saida.write(v);
		}
		
		entrada.close();
		saida.close();
		System.out.println("OK");
	}
}
