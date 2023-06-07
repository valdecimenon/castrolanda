package java16;

public class WarningsValueBasedClasses {

	public static void main(String[] args) {
		
		// warning: The constructor Integer(int) has been deprecated since version 9 and marked for removal
		Integer a = new Integer(123);
		
		// nova forma de uso para boxing manual
		Integer b = Integer.valueOf(123);
		
		// é mais prático usar auto boxing
		Integer c = 123;
		
		// qualquer classe Wrapper
		Double d = new Double(3.14);
		
		Double e = Double.valueOf("3.14");  // também pode ser string
		
		Boolean f = Boolean.valueOf("true");

	}

}
