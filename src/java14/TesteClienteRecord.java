package java14;

public class TesteClienteRecord {

	public static void main(String[] args) {
		ClienteRecord cliente = new ClienteRecord(1L, "Rafael");
		System.out.println(cliente);
		System.out.println(cliente.id());
		System.out.println(cliente.nome());
	}
}
