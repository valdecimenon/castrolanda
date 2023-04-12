package estatico;

public class Circunferencia {

	public final static double PI = 3.14159; 
	
	public int raio  = 5;
	
	public static void mostrarValorPI() {
		System.out.println(PI);
	}
	
	public void calcularArea() {
		System.out.println(PI * raio * raio);
	}
}
