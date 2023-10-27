package com.softgraf.primavera;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.softgraf.primavera.service.CrudService;
import static java.lang.System.out;

// @EnableJpaRepositories(basePackages =  "com.softgraf.primavera.repository")
@SpringBootApplication
public class PrimaveraApplication implements CommandLineRunner {


	private final CrudService crudService;
	
	
	// CrudService será injetado pelo Spring
	public PrimaveraApplication(CrudService crudService) {
		System.out.println("PrimaveraApplication instanciado pelo Spring");
		this.crudService = crudService;
	}

	public static void main(String[] args) {
		System.out.println("Iniciou main()");
		SpringApplication.run(PrimaveraApplication.class, args);
		System.out.println("Finalizou main()");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executou método run()");
		Scanner scanner = new Scanner(System.in);
		boolean rodar = true;
		
		while (rodar) {
			out.println("\n\n==== Sistema Primavera =====");
			out.println("1 - Cadastra 3 produtos padrões");
			out.println("2 - Cadastra um novo produto");
			out.println("3 - Cadastra 100 produtos aleatórios");
			out.println("4 - Lista todos os produtos");
			out.println("5 - Busca produto por descrição");
			out.println("6 - Lista produtos com paginação (20/pag) em ordem ASC por id");
			out.println("7 - Sair");
			
			int opcao = 0;
			while (opcao < 1 || opcao > 7) {
				out.println("Qual opção?");
				opcao = scanner.nextInt();
			}
			
			switch (opcao) {
				case 1 -> crudService.cadastra3produtos();
				case 2 -> crudService.cadastraNovoProduto();
				case 3 -> crudService.cadastra100Produtos();
				case 4 -> crudService.listaTodosProdutos();
				case 5 -> crudService.buscarPorDescricao();
				case 6 -> crudService.listaProdutosComPaginacao("id");
				case 7 -> rodar = false;
			}
		}
		
		scanner.close();
		out.println("\nFui! Tchau! Adeus!!!");
	}

}
