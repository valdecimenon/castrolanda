package classes.internas;

public class ClasseExterna2 {

	public static void main(String[] args) {
		OutraClasse oc = new ClasseExterna2().new OutraClasse();
		OutraClasse.ClassInterna ci = oc.new ClassInterna();
		System.out.println(ci.mensagem());
	}
	
	
	
	// classe interna
	class OutraClasse {
		
		// classe interna aninha
		class ClassInterna {
			
			public String mensagem() {
				return "Texto da classe interna aninhada";
			}
		}
		
	}
}
