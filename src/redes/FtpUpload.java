package redes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
 * "ftp://usuario:senha@softgraf.com/teste_ftp/arquivo" 
 * usuario = cursojava@softgraf.com
 * senha = cursojava
 */

// softgraf.com/cursojava/teste_ftp
public class FtpUpload {

	public static void main(String[] args) throws IOException {

		String ftpUsuario = URLEncoder.encode("cursojava@softgraf.com", "UTF-8");
		String ftpSenha = URLEncoder.encode("cursojava", "UTF-8");
		String ftp = String.format("ftp://%s:%s@softgraf.com/teste_ftp/por_do_sol_valdeci.jpg", ftpUsuario, ftpSenha);

		URL url = new URL(ftp);
		URLConnection conexao = url.openConnection();
		OutputStream saida = conexao.getOutputStream();
		
		FileInputStream entrada = new FileInputStream("e:/por_do_sol.jpg");
		int v;

		System.out.println("\nFazendo upload...");
		while ((v=entrada.read()) != -1) {
			saida.write(v);
		}
		
		entrada.close();
		saida.close();
		System.out.println("OK");
	}
}
