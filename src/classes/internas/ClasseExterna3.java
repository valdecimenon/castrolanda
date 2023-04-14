package classes.internas;

public class ClasseExterna3 {

	public static void main(String[] args) {
		System.out.println(new ClasseExterna3().somar(5, 7));
	}
	
	// classe aninhada dentro de um método
	public double somar(double n1, double n2) {
		
		class SomadorInterno {
			double a, b;
			
			public SomadorInterno(double n1, double n2) {
				a = n1;
				b = n2;
			}
			
			public double soma() {
				return a + b;
			}
		}
		
		SomadorInterno si = new SomadorInterno(n1, n2);
		return si.soma();
		
	}
	
	
}
