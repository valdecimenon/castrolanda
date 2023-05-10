package excecoes;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ErrorPrintStream extends PrintStream {

	public ErrorPrintStream(OutputStream outputStream) {
		super(outputStream);
	}
	
	@Override
	public void println(String msg) {
		String usuario = System.getProperty("user.name");
		super.println(usuario + " " + new Date() + " " +  msg);
		System.out.println("Erro: " + msg);
	}

}
