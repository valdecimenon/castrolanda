package com.softgraf.primavera.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softgraf.primavera.entity.Produto;


@Repository // estereótipo opcional
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	// a partir da segunda chamada, este método não consulta mais o banco de dados
	@Cacheable("descricao_produto")
	List<Produto> findByDescricaoContaining(String descricao, Sort sort);
	

}
