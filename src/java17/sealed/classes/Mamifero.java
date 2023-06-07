package java17.sealed.classes;

// modificador sealed
// pemite que classes e interfaces tenham mais controle sobre seus subtipos permitidos
// usar sealed e permits
// classes filhas devem estender obrigatoriamente
public abstract sealed class Mamifero permits Cao, Gato {

	public abstract void fazerBarulho();
	
}
