package trycatch;

public class ExemploSemMultiCatch {

	public static void main(String[] args) {
		int vetor[] = new int[3];
		Object obj = null;
		
		try {
			int x = 5 / 0;
			vetor[9] = 0;
			obj.toString();
			
		} catch (ArithmeticException e) {
			System.out.println("Erro: divisão por zero.");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: Índice de array fora dos limites");
			
		} catch (NullPointerException e) {
			System.out.println("Erro: ponteiro nulo");
		}

	}

}
