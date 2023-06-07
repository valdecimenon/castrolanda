package java15;

public class BlocosTexto {

	public static void main(String[] args) {
		// antes do java 15...
		String txtOld = "Este é texto " +
						"de múltiplas " +
						"linhas, antes do " +
						" Java 15";
		System.out.println(txtOld);
		
		String txtBlock = """
							Este é um texto \
							usando o recurso de bloco \
							do Java 15 \
							Use \\ no final para não mudar de linha
						  """;
		System.out.println(txtBlock);

		
		String json = """
						{
							"id": "1",
							"endereco": {"rua": "Santana", "numero": 820},
							"cidade": "Ponta Grossa",
							"uf": "PR"
						}
				      """;
		System.out.println(json);
		
		String query = """
						SELECT * \
						FROM Cliente \
						WHERE sobrenome LIKE "%Silva%";
						""";
		System.out.println(query);
		
	}

}
