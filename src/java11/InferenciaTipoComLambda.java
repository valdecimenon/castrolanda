package java11;

import java.util.Arrays;
import java.util.List;

public class InferenciaTipoComLambda {

	public static void main(String[] args) {

		List<Number> lista = Arrays.asList(1, 2, 3, 3.3, 4.4, null, 5, 1L);

		// podemos escrever simplesmente
		// lista.forEach(n -> { ....

		// porém podemos usar inferência quando necessário usarmos anotações específicas
		lista.forEach((@NonNullVar var n) -> {

			if (n instanceof Integer)
				System.out.println("Integer"); 

			else if (n instanceof Double)
				System.out.println("Double");

			else if (n == null)
				System.out.println("null");

			else if (n instanceof Number)
				System.out.println("Number");
		});
	}

}
