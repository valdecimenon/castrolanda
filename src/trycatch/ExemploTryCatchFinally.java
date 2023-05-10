package trycatch;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;

public class ExemploTryCatchFinally {

	public static void main(String[] args) throws FileNotFoundException {
		
		// arquivo não existe
		String nomeArq = "teste1.txt";
		FileInputStream arquivo = null;
		
		try {
			arquivo = new FileInputStream(nomeArq);
			out.println("sem erros");
			
			// este bloco só é executado se a excessão for lançada por try
		} catch (FileNotFoundException e) {
			// por exemplo: pode redirecionar a mensagem para um arquivo de log
			out.println("Arquivo não encontrado");
			// depois pode tratar ou relançara exceção, como neste exemplo
			throw e;  // relança
			
			// este bloco é incondicionalmente executado
		} finally {
			out.println("bloco finally");

			try {
				// if (arquivo != null) {
				arquivo.close();
				
			  // recurso multi catch: uma única variável
			} catch (NullPointerException | IOException e) {
				out.println("Erro ao fechar arquivo\n");
			}
		}
		
		// este bloco  não é executado quando throw lançaa a exceção
		out.println("Fim");
	}
}
