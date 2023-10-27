package com.softgraf.primavera.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softgraf.primavera.data.dto.ProdutoRecordDTO;
import com.softgraf.primavera.entity.Produto;
import com.softgraf.primavera.repository.ProdutoRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api")
public class ProdutoApiController {

	@Autowired
	private ProdutoRepository repository;
	
	// localhost:8080/api/cadastrar
	@PostMapping("cadastrar")
	public Produto cadastrar(@RequestBody @Valid ProdutoRecordDTO produtoDTO) {
		return repository.save(produtoDTO.toProduto());
	}
	
	// localhost:8080/api/listar
	@GetMapping("/listar")
	public List<Produto> listarTodos(){
		return repository.findAll();
	}
	
	// busca produto por id
	// localhost:8080/api/produto/52
	@GetMapping("/produto/{id}")    
	public Produto buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}
	
	// salva ou atualiza
	// localhost:8080/api/produto/1
	@PutMapping("/produto/{id}")
	public Produto atualizarPorId(@RequestBody @Valid ProdutoRecordDTO produtoDTO, @PathVariable Long id) {
		return repository.findById(id).map(produto -> {
			produto.setDescricao(produtoDTO.descricao());
			produto.setPreco(produtoDTO.preco());
			produto.setQuantidade(produtoDTO.quantidade());
			produto.setUrlImagem(produtoDTO.urlImagem());
			return repository.save(produto); // atualiza
		}).orElseGet(() -> {
			return repository.save(produtoDTO.toProduto());  // cria um novo
		});
	}
	
	// apaga um produto por id
	// localhost:8080/api/produto/2
	@DeleteMapping("/produto/{id}")
	public void deletarPorId(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
