package com.softgraf.primavera.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softgraf.primavera.data.projection.ClienteProjection;
import com.softgraf.primavera.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// este método já existe, criado automaticamente pelo Spring Data com base nos campos da entidade
	// List<Cliente> findByNome(String nome);

	// Métodos personalizados
	// String nome = "%maria%"
	// busca nome usando: SELECT * from Cliente WHERE nome LIKE "%maria%"
	List<Cliente> findByNomeLike(String nome);
	
	// Containing
	// String nome = "maria"
	List<Cliente> findByNomeContaining(String nome);
	List<Cliente> findByEmailContaining(String email);
	
	// Starting e Ending
	List<Cliente> findByNomeStartingWith(String nome);
	List<Cliente> findByNomeEndingWith(String sobrenome);
	
	// Null or Not Null
	List<Cliente> findByNomeIsNull();
	List<Cliente> findByNomeIsNotNull();
	
	// Busca com ordenação
	List<Cliente> findByNomeOrderByNomeAsc(String nome);
	List<Cliente> findByNomeOrderByNomeDesc(String nome);
	
	// Busca com ordenação usando Sort
	// Sort sort = Sort.by(Sort.Direction.ASC, "nome")
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	// Busca com classe aninhada
	List<Cliente> findByEndereco_CidadeContaining(String cidade);
	List<Cliente> findByEndereco_BairroContaining(String bairro);
	List<Cliente> findByEndereco_Estado(String estado);
	List<Cliente> findByEndereco_Cep(String cep);
	
	// Busca com paginação e ordenação: interface PagingAndSortingRepository
	// JpaRepository extends PagingAndSortingRepository
	// Pageable pageable = PageRequest.of(1, 30, Sort.by(Sort.Direction.ASC, "email"))
	Page<Cliente> findAll(Pageable pageable);
	// Página atual: clientes.getNumber()   // 0..n
	// Total de itens da consulta: clientes.getTotalElements()
	
	// === Queries == 
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Pageable pageable);

	
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Sort sort);
	
	// === Native Queries ===
	@Query(value="SELECT * FROM Cliente WHERE nome = ?1", nativeQuery=true)
	List<Cliente> findByNome(String nome);

	// query usando Interface-Based Projection
	@Query(value="SELECT c.id, c.nome, c.email FROM Cliente c", nativeQuery=true)
	List<ClienteProjection> findClienteProjecao();
	
	// === JPA Named Queries ===
	List<Cliente> buscarPF();
	List<Cliente> buscarPJ();

}

