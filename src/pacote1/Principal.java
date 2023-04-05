package pacote1;

// Objetivo: compreender herança, polimorfismo, sobrescrita, sobrecarga, classe concreta e abstrata

public class Principal {

	
	public static void main(String[] args) {
		// polimorfismo
		// o objeto instanciado é um cão
		// porém o comportamento pode ser
		// de Cao: podemos chamar todos os métodos heradados e os implementados direto na classe
		// de Mamifero: não podemos chamar os métodos da classe Cao, apenas os de Mamifero
		// Animal: somente os métodos de Animal e os herdados (Object)
		Cao cao = new Cao("mamifero", "Toto");
		Mamifero mamifero = new Cao("mamifero", "Toto");
		Animal animal = new Cao("mamifero", "Toto");
		
		// erro
		// animal.latir();
		
		// porém podemos chamar um objeto do objeto, fazendo um casting
		((Cao) animal).latir();  // AU AU AU
		
	    // É FUNDAMENTAL compreender o polimorfismo!
		// Basicamente existem o polimorfismo de classe e o de método
		// De classe: como no exemplo acima, usando sobrescrita de método
		// De método: quando temos métodos com o mesmo nome, porém assinaturas diferentes, na mesma classe
		
		// aqui chamamos os métodos SOBRECARREGADOS de Cao
		cao.latir();
		cao.latir("WOOF WOOF WOOF"); 

	}

}
