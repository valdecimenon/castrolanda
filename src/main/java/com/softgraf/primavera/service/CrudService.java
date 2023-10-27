package com.softgraf.primavera.service;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.softgraf.primavera.entity.Produto;
import com.softgraf.primavera.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository repository;

	// ProdutoRepository será injetado pelo Spring
	public CrudService(ProdutoRepository repository) {
		System.out.println("CrudService instanciado pelo Spring");
		this.repository = repository;
	}
	
	public void cadastra3produtos() {
		Produto p1 = new Produto("Liquidificador Brastemp", 199.99f, 10);
		Produto p2 = new Produto("Batedeira Arno", 250.89f, 12);
		Produto p3 = new Produto("Ferro de passar Black&Decker", 99.79f, 15);
		
		repository.save(p1);
		repository.save(p2);
		repository.save(p3);
		System.out.println("=== Produtos salvos ===");
	}
	
	public void cadastraNovoProduto() {
		Scanner scanner = new Scanner(System.in);
		Produto p = new Produto();
		
		System.out.println("Descrição:");
		p.setDescricao(scanner.nextLine());
		
		System.out.println("Preço:");
		p.setPreco(scanner.nextFloat());
		
		System.out.println("Quantidade:");
		p.setQuantidade(scanner.nextInt());
		
		repository.save(p);
		System.out.println("=== produto ===");
//		scanner.close();
	}
	
	public void listaTodosProdutos() {
		System.out.println("\n\n=== Listando Todos os Produtos ===");
		repository.findAll().forEach(System.out::println);
	}
	
	public void buscarPorDescricao() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a descrição do produto:");
		String descricao = scanner.nextLine();
		Sort sort = Sort.by("descricao").descending();
		
		List<Produto> lista = repository.findByDescricaoContaining(descricao, sort);
		if (lista.isEmpty())
			System.out.println("\nNenhum produto encontrado com essa descrição");
		else
			lista.forEach(System.out::println);
	}
	
	private String randomTexto(int quantidade) {
		StringBuilder builder = new StringBuilder();
		int base = 97;  // "a"
		for (int i=0; i<quantidade; i++) {
			char letra = (char) (base + (Math.random() * 26)); // "a".."z"
			builder.append(letra);
		}
		
		return builder.toString();
	}
	
	public void cadastra100Produtos() {
		for (int i=1; i<=100; i++) {
			Produto p = new Produto();
			p.setDescricao(randomTexto(5) + " " + randomTexto(7));            // "eosnc akdpwqu"
			p.setPreco((float) Math.random() * 100);   // 0.1 a 99.9
			p.setQuantidade(1 + (int) (Math.random() * 300));
			
			repository.save(p);
			System.out.printf("\nProduto %d/100 salvo", i);
		}
	}
	
	public void listaProdutosComPaginacao(String campo) {
		// um Pageab le é como um índice de um livro
		Pageable paginacao = PageRequest.of(0, 20, Sort.by(campo).ascending());
		
		// um Page é como uma página de um livro
		Page<Produto> pagina = repository.findAll(paginacao);
		out.println("\n\n>>Total de páginas: " + pagina.getTotalPages());  // 0..n
		out.println(">>Página atual: " + pagina.getNumber());
		out.println(">>Itens por página: " + pagina.getSize());  //0..n
		out.println(">>Total de itens da consulta: " + pagina.getTotalElements());
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		
		do {
			out.println("\n\n===== Menu de Paginação =====");
			out.println("MOSTRAR - conteúdo da página atual");
			out.println("PROX - vai para a próxima página");
			out.println("ANT - vai para a página anterior");
			out.println("PRI - vai para a primeira página");
			out.println("ULT - vai para a última página");
			out.println("CONV - converte página atual em lista");
			out.println("FIM - sai do menu");
			
			out.println("Qual opção?");
			escolha = scanner.next().toUpperCase();
			
			switch(escolha) {
			
				case "MOSTRAR" -> {
					out.println("\n\n----- Exibindo página: " + pagina.getNumber());
					pagina.forEach(out::println);
				}
				
				case "PROX" -> {
					if (pagina.hasNext()) {
						pagina = repository.findAll(pagina.nextPageable());
						out.println("\n\n**** Foi para a página: " + pagina.getNumber());
					} else 
						out.println("\n\n*** Não há próxima página");
				}
				
				case "ANT" -> {
					if (pagina.hasPrevious()) {
						pagina = repository.findAll(pagina.previousPageable());
						out.println("\n\n**** Foi para a página: " + pagina.getNumber());
					} else 
						out.println("\n\n*** Não há próxima anterior");
				}
				
				case "PRI" -> {
					pagina = repository.findAll(paginacao.first());
					out.println("\n\n**** Foi para a página: " + pagina.getNumber());
				}
				
				case "ULT" -> {
					paginacao = PageRequest.of(pagina.getTotalPages() - 1, 20, Sort.by(campo).ascending());
					pagina = repository.findAll(paginacao);
					out.println("\n\n**** Foi para a página: " + pagina.getNumber());
				}
				
				case "CONV" -> {
					// converte página em lista, mas não faz nada
					List<Produto> lista = pagina.getContent();
					out.println("\n\n*** Convertou pagina em lista");
				}
				
				case "FIM" -> out.println("\n\n*** Saiu do menu de paginação");
				
				default -> out.println("\n*** Opção inválida");
			}
			
			
		} while (!escolha.equals("FIM"));
	}
	
	
}
