package java09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Factory Methods
 * Java 9 inclui métodos estáticos para as interfaces List, Set e Map
 * Estes métodos são úteis para criar pequenas coleções de objetos.
 */
public class FabricaDeCollections {

	public static void main(String[] args) {

		// usando método add()
		List<String> frutas = new ArrayList<>();
		frutas.add("banana");
		frutas.add("uva");
		frutas.add("laranja");
		frutas.add("pera");
		frutas.add("maçã");
		frutas.add("kiwi");
		// devole uma coleção imutável
		List<String> frutasImutaveis = Collections.unmodifiableList(frutas);
		frutasImutaveis.forEach(System.out::println);
		
		// cria uma lista imutável
		System.out.println("\nLista usando factory method of()");
		List<String> carros = List.of("Gol", "Palio", "Bravo", "Camaro", "Ferrari");
		carros.forEach(System.out::println);
		
		// cria um conjunto imutável
		System.out.println("\nConjunto usando factory method of()");
		Set<String> java = Set.of("Java", "JavaFX", "Spring", "Hibernate", "JSP", "JSF");
		java.forEach(System.out::println);
		
		// cria um mapa imutável
		System.out.println("\nMap usando factory method of()");
		//   key      value
		Map<String, String> clientes = Map.of("Bruno", "42 9999-8888", "Gabriel", "42 9999-8888", "Valdeci", "42 9999-8888");

		for (Map.Entry<String, String> c : clientes.entrySet()) {
			System.out.println(c.getKey() + " = " + c.getValue());
		}
	}	
}
