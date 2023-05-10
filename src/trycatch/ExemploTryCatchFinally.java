package trycatch;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;

public class ExemploTryCatchFinally {

	public static void main(String[] args) throws FileNotFoundException {
		
		// arquivo n�o existe
		String nomeArq = "teste1.txt";
		FileInputStream arquivo = null;
		
		try {
			arquivo = new FileInputStream(nomeArq);
			out.println("sem erros");
			
			// este bloco s� � executado se a excess�o for lan�ada por try
		} catch (FileNotFoundException e) {
			// por exemplo: pode redirecionar a mensagem para um arquivo de log
			out.println("Arquivo n�o encontrado");
			// depois pode tratar ou relan�ara exce��o, como neste exemplo
			throw e;  // relan�a
			
			// este bloco � incondicionalmente executado
		} finally {
			out.println("bloco finally");

			try {
				// if (arquivo != null) {
				arquivo.close();
				
			  // recurso multi catch: uma �nica vari�vel
			} catch (NullPointerException | IOException e) {
				out.println("Erro ao fechar arquivo\n");
			}
		}
		
		// este bloco  n�o � executado quando throw lan�aa a exce��o
		out.println("Fim");
	}
}
