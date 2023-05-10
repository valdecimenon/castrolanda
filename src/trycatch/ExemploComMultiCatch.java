package trycatch;

// somente a partir do Java 7
public class ExemploComMultiCatch {

	public static void main(String[] args) {
		int vetor[] = new int[3];
		Object obj = null;
				
		try {
			int x = 5 / 0;
			vetor[9] = 0;
			obj.toString();
			
		// | = OU Exclusivo
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Erro: divis�o por zero, �ndice de array fora dos limites ou ponteiro nulo.");	
		}

	}

}
