package java10;

import java.util.ArrayList;

// LVTI = Local Variable Type Inference  ("tipagem dinânimca")
public class InferenciaVariavelLocal {

	// não permitido na classe, apenas em escopo local
	// var id = 1;
	
	public static void main(String[] args) {
		
		var num = 3.14;
		System.out.printf("%.2f\n", num);
		
		var msg = "Hello java 10";
		System.out.println(msg);
		
		var lista = new ArrayList<String>();
		lista.add("celular");
		lista.add("tv");
		lista.forEach(System.out::println);
		
		var obj = new InferenciaVariavelLocal();
		System.out.println(obj);
		
		// variável precisa ser inicializada
		/*
		var x;
		var x = null;
		*/
	}
}
