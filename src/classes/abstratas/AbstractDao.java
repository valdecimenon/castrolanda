package classes.abstratas;

// criei uma classe 100% abstrata!
// sempre que tivermos uma classe 100% abstrata, podemos trocar por uma interface!
// pois uma interface é como uma classe 100% abstrata
abstract public class AbstractDao {

	public double valor = 5.55;
	
	public abstract void insert();
	
	public abstract void delete();
	
	public abstract void update();
	        
	public abstract void list();
}

// reescrevendo o código
/*

// porém não posso ter variáveis em interfaces!!
//  apenas constantes
// 
  
 /*
public interface AbstractDao {
	final double PI = 3.14;

	void insert();
	
	void delete();
	
	void update();
	
	void list();
}


*/