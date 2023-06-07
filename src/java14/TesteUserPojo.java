package java14;

public class TesteUserPojo {

	public static void main(String[] args) {
		UserPojo usuario = new UserPojo("João da Silva", "senha123");
		System.out.println(usuario);
		System.out.println(usuario.getNome());
		System.out.println(usuario.getSenha());
	}

}
